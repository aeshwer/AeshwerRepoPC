package com.tradingserver.launcher;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HFTDownStreamServerMain {


	public static void main(String[] args) {
		//Create the connection factory
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		//Create the consumer. It will wait to listen to the Topic
		Thread topicConsumerThread = new Thread(new TopicConsumer(connectionFactory));
		topicConsumerThread.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
