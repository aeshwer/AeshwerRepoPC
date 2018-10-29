package com.tradingserver.jmsconsumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class HFTQueueMessageListener implements MessageListener{
	
	private static final String consumerName = HFTQueueMessageListener.class.getName();
	
	public HFTQueueMessageListener() {
	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("[ "+ consumerName + "] Trade Received on DownStreamServer is recieved" +textMessage.getText());
		}catch(JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
