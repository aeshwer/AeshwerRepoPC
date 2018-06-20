package PersistenceUtil;


import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericEntityManagerFactory {
	 private EntityManagerFactory entityManagerFactory;

	  public GenericEntityManagerFactory(
	      String persistenceUnitName, Map<String, String> properties) {
	    this.entityManagerFactory =
	        Persistence.createEntityManagerFactory(persistenceUnitName, properties);
	  }

	  public void close() {
	    Optional.ofNullable(this.entityManagerFactory).ifPresent(EntityManagerFactory::close);
	  }

	  public EntityManagerFactory getEntityManagerFactory() {
	    return entityManagerFactory;
	  }
	}
