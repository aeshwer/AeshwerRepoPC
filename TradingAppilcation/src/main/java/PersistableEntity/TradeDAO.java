package PersistableEntity;

import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import Domain.Trade;
import Domain.TradePersistableToDomainMapper;
import PersistenceUtil.TransactionUtil;
import Util.TradeGateway;

public class TradeDAO /*extends GenericDAOManagerEntity*/ implements TradeGateway{

	//private GenericEntityManagerFactory genericEntityManagerFactory;

	//private	EntityManager entityManager;
	
	private EntityManagerFactory entityManagerFactory;

	public TradeDAO() {
		//this.genericEntityManagerFactory = genericEntityManagerFactory;	
		this.entityManagerFactory = HibernateEntityManageUtil.getEntityManager();
	}

	public void persist(TradePersistable persistable) {
		//super.Perist(persistable);
		TransactionUtil.doInJPA(entityManagerFactory, entityManager -> {
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(persistable);
			transaction.commit();
		});
		/*entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(persistable);
		entityManager.getTransaction().commit();
		entityManager.close();*/
	}

	public Trade findTradeById(int tradeId) {
		// get an object using primary key.
		
		/*try{
		entityManager = entityManagerFactory.createEntityManager();
		//entityManager.getTransaction().begin();
		TradePersistable temp = entityManager.find(TradePersistable.class, tradeId);
		TradePersistableToDomainMapper mapedTrade = new TradePersistableToDomainMapper(temp);
		return mapedTrade.PersistableToDomainMapper();}
		finally {
		entityManager.close();
		}*/

		final AtomicReference<TradePersistable> temp = new AtomicReference<>();
		TransactionUtil.doInJPA(entityManagerFactory, entityManager -> {
			temp.set(entityManager.find(TradePersistable.class, tradeId));
		});
		TradePersistableToDomainMapper mapedTrade = new TradePersistableToDomainMapper(temp.get());
		return mapedTrade.PersistableToDomainMapper();
	}

	@Override
	public boolean updateTrade(int tradeId) {
		return false;
	}


}
