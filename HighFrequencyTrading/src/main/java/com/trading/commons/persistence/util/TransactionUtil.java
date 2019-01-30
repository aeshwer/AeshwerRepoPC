package com.trading.commons.persistence.util;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.commons.lang3.Validate;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TransactionUtil {

	private TransactionUtil() {
		// Do Nothing
	}
	public static void doInJPA(Logger logger,
			EntityManagerFactory entityManagerFactory, Consumer<EntityManager> work) {
		TransactionUtil.doInJPA(logger,entityManagerFactory, work, null);
	}

	public static void doInJPA(Logger logger,
			EntityManagerFactory entityManagerFactory,
			Consumer<EntityManager> work,
			Consumer<Exception> failure) {
		Validate.notNull(entityManagerFactory, "EntityManagerFactory cannot be null.");
		Validate.notNull(work, "Work to be done with entityManager cannot be null.");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			work.accept(entityManager);
		} catch (Exception e) {
			if (failure != null) {
				failure.accept(e);
			} else {
				logger.log(Level.DEBUG, e.getMessage(), e);
				throw e;
			}
		} finally {
			entityManager.close();
		}
	}
}
