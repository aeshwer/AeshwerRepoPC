package com.tradingserver.launcher;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import com.trading.util.LogManagerUtil;

public class TopicConsumer implements Runnable {

	private final static Logger logger = LogManagerUtil.getLogger(TopicConsumer.class);
	
	private ActiveMQConnectionFactory connectionFactory ;

	public TopicConsumer(ActiveMQConnectionFactory connectionFactory) {
		this.connectionFactory = connectionFactory;
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
			Destination topicDestination = session.createQueue("HighFreqTradeTopic");

			// Create a MessageProducer from the Session to the Topic or Queue
			MessageConsumer messageConsumer = session.createConsumer(topicDestination);

			//Wait here till we get the message
			Message message = messageConsumer.receive();
			
			TextMessage textMessage = (TextMessage)message;
			logger.info("Trade Received on DownStreamServer is  ....................."+textMessage.getText());

			// Do the cleanup
			session.close();
			connection.close();
		} catch (JMSException jmse) {
			System.out.println("Exception: " + jmse.getMessage());
		}
	}
}