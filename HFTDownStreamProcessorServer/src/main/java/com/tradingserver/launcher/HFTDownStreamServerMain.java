package com.tradingserver.launcher;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HFTDownStreamServerMain {

	private static Connection connection = null;
	
	public static void main(String[] args) throws URISyntaxException,  Exception /*throws URISyntaxException, Exception */{
		try {

			ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue("HighFreqTradeTopic");
			MessageConsumer consumer = session.createConsumer(queue);
			consumer.setMessageListener(new HFTQueueMessageListener	("Consumer"));
		}finally
		{
			if (connection != null) {
				connection.close();
			}
			//broker.stop();
		}
	}
}
