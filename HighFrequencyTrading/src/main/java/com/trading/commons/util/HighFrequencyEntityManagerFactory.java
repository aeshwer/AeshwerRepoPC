package com.trading.commons.util;

import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HighFrequencyEntityManagerFactory  implements EntityManagerFactoryWrapper {

	private EntityManagerFactory entityManagerFactory;
	
	public HighFrequencyEntityManagerFactory() {
		this.entityManagerFactory =
		        Persistence.createEntityManagerFactory("persistence");
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return this.entityManagerFactory;
	}

	@Override
	public void close() {
		Optional.ofNullable(this.entityManagerFactory).ifPresent(EntityManagerFactory::close);		
	}
}
