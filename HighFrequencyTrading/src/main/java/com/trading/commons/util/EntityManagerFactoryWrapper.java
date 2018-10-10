package com.trading.commons.util;

import javax.persistence.EntityManagerFactory;

public interface EntityManagerFactoryWrapper 
{

	EntityManagerFactory getEntityManagerFactory();

	void close();
}
