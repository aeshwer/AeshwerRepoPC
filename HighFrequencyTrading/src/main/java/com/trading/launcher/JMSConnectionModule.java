package com.trading.launcher;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class JMSConnectionModule extends AbstractModule {

	@Override
	protected void configure() {
		// Nothing to put here.
	}

	@Provides
	@Singleton
	public ConnectionFactory getJmsConnectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}

	@Provides
	@Singleton
	public Connection getConnection(final ConnectionFactory connectionFactory) throws JMSException {
		return connectionFactory.createConnection();
	}
}
