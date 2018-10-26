package com.trading.jms.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.trading.domain.trade.Trade;

public class TopicProducer implements Runnable { 

	//Connection Factory which will help in connecting to ActiveMQ serer
	private  ActiveMQConnectionFactory connectionFactory = null;

	private Trade trade;

	public TopicProducer(ActiveMQConnectionFactory connectionFactory,Trade trade) {
		this.connectionFactory = connectionFactory;
		this.trade = trade;
	}

	@Override
	public void run() {
		try {
			// First create a connection
			Connection connection = connectionFactory.createConnection();
			connection.start();

			// Now create a Session
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

			// Let's create a topic. If the topic exist, it will return that
			Destination destination = session.createQueue("HighFreqTradeTopic");

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			// Create a messages for the current climate
			String text = trade.toString();
			TextMessage message = session.createTextMessage(text);

			// Send the message to topic
			producer.send(message);

			// Do the cleanup
			session.close();
			connection.close();
		} 
		catch (JMSException jmse) {
			System.out.println("Exception: " + jmse.getMessage());
		}
	}
}
