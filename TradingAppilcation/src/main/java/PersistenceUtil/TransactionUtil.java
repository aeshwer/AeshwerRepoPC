package PersistenceUtil;

import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TransactionUtil {

	private TransactionUtil() {
		// Do Nothing
	}
	public static void doInJPA(
			EntityManagerFactory entityManagerFactory, Consumer<EntityManager> work) {
		TransactionUtil.doInJPA(entityManagerFactory, work, null);
	}

	public static void doInJPA(
			EntityManagerFactory entityManagerFactory,
			Consumer<EntityManager> work,
			Consumer<Exception> failure) {
		notNull(entityManagerFactory, "EntityManagerFactory cannot be null.");
		notNull(work, "Work to be done with entityManager cannot be null.");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			work.accept(entityManager);
		} catch (Exception e) {
			if (failure != null) {
				failure.accept(e);
			} else {
				throw e;
			}
		} finally {
			entityManager.close();
		}
	}

	private static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
}
