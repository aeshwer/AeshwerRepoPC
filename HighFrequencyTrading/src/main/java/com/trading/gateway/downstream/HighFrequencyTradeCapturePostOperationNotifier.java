package com.trading.gateway.downstream;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.jms.producer.HFTDownStreamNotifierPublisher;

public class HighFrequencyTradeCapturePostOperationNotifier {

	private  ExecutorService executorService = Executors.newCachedThreadPool(); 
	
	private ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	@Inject
	public HighFrequencyTradeCapturePostOperationNotifier() {
	}

	public void perform(final Trade trade) {
		//Create a message. As soon as the message is published on the Queue, it will be consumed by the consumer
		executorService.submit(new HFTDownStreamNotifierPublisher(connectionFactory,trade));
	}

}
