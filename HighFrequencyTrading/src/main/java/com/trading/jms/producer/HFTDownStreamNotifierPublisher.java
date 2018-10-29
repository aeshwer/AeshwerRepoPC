package com.trading.jms.producer;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeConstant;

public class HFTDownStreamNotifierPublisher implements Runnable { 

	//Connection Factory which will help in connecting to ActiveMQ serer
	private  ActiveMQConnectionFactory connectionFactory = null;

	private Trade trade;
	
	private static final String HFT_QUEUE = "HighFreqTradeQueue";

	public HFTDownStreamNotifierPublisher(ActiveMQConnectionFactory connectionFactory,Trade trade) {
		this.connectionFactory = connectionFactory;
		this.trade = trade;
	}

	@Override
	public void run() {
		try {
			// First create a connection
			Connection connection = connectionFactory.createConnection();
			//connection.start();

			// Now create a Session
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

			// Let's create a Queue. If the queue exist, it will return that
			Destination destination = session.createQueue(HFT_QUEUE);

			// Create a MessageProducer from the Session to the topic or Queue
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.PERSISTENT);

			// Create a messages for the HighFreqTradeTopic Queue
			/*String text = trade.toString();
			TextMessage message = session.createTextMessage(text);*/
			
			Message message = session.createMessage();
			message.setLongProperty(TradeConstant.TRADE_ID, trade.getTradeId());
			message.setStringProperty(TradeConstant.TRADE_STATUS, trade.getTradeStatus().toString());
			message.setStringProperty(TradeConstant.TRADE_DATE, trade.getTradeDate().toString());

			// Send the message to Queue
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
