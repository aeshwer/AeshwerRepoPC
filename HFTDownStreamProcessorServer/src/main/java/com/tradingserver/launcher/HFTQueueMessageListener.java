package com.tradingserver.launcher;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class HFTQueueMessageListener implements MessageListener{
	
	private String consumerName;

	public HFTQueueMessageListener(String consumerName) {
		this.consumerName = consumerName;

	}

	@Override
	public void onMessage(Message message) {
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("[ "+ consumerName + "] Trade Received on DownStreamServer is recieved"+textMessage.getText());
		}catch(JMSException e) 
		{
			e.printStackTrace();
		}
	}
}
