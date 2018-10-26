package com.trading.gateway.downstream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.region.Topic;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.jms.producer.TopicProducer;

public class HighFrequencyTradeCapturePostOperationNotifier {

	private  ExecutorService executorService = Executors.newCachedThreadPool(); 
	
	ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	@Inject
	public HighFrequencyTradeCapturePostOperationNotifier() {
	}

	public void perform(final Trade trade) {
		//Create a message. As soon as the message is published on the Topic, it will be consumed by the consumer
		executorService.submit(new TopicProducer(connectionFactory,trade));
	}

}
