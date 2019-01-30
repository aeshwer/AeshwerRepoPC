package com.trading.commons.persistence.util;

import javax.persistence.EntityManagerFactory;

public interface EntityManagerFactoryWrapper 
{

	EntityManagerFactory getEntityManagerFactory();

	void close();
}
