package com.trading.commons.persistence.util;

import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HighFrequencyEntityManagerFactory  implements EntityManagerFactoryWrapper {

	private EntityManagerFactory entityManagerFactory;
	
	/* Compatible with Old method	
	public HighFrequencyEntityManagerFactory() {
		this.entityManagerFactory =
		        Persistence.createEntityManagerFactory("persistence");
	}*/
	
	 public HighFrequencyEntityManagerFactory(
		      final String persistenceUnitName, final Map<String, String> properties) {
		    this.entityManagerFactory =
		        Persistence.createEntityManagerFactory(persistenceUnitName, properties);
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
