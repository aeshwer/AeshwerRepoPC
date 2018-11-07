package com.tradingserver.launcher;

import java.net.URISyntaxException;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import com.trading.util.LogManagerUtil;
import com.tradingserver.jmsconsumer.HFTQueueMessageListener;

public class HFTDownStreamServerMain {

	private static Connection connection = null;
	
	private static final String HFT_QUEUE = "HighFreqTradeQueue";

	private final static Logger logger = LogManagerUtil.getLogger(HFTDownStreamServerMain.class);

	public static void main(String[] args) throws URISyntaxException,  Exception {
		logger.info("***********High Frequency Trading DownStream Server App Starts: "+" ***************");
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		try {
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
			Destination queue = session.createQueue(HFT_QUEUE);
			MessageConsumer consumer = session.createConsumer(queue);
			consumer.setMessageListener(new HFTQueueMessageListener	());
		}
		finally
		{
			if (connection != null) {
				connection.close();
			}
		}
	}
}
