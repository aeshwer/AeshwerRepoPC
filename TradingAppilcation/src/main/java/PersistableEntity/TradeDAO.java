package PersistableEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import Domain.Trade;
import Util.TradeGateway;

public class TradeDAO /*extends GenericDAOManagerEntity*/ implements TradeGateway{

	private TradePersistable persistable;
	
	//private GenericEntityManagerFactory genericEntityManagerFactory;
	
	private EntityManagerFactory entityManagerFactory;
	
	private	EntityManager entityManager; 

	public TradeDAO() {
		//this.genericEntityManagerFactory = genericEntityManagerFactory;	
		this.entityManagerFactory = HibernateEntityManageUtil.getEntityManager();
		}

	public void persist(TradePersistable persistable) {
		//super.Perist(persistable); 
		entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(persistable);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

	public Trade findTradeById(String tradeId) {
		return null;
	}
	

}
