package PersistableEntity;

import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import Domain.Trade;
import Domain.TradeDomainToPersistableMapper;
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
	public Trade copyTrade(int tradeId) {
		final AtomicReference<TradePersistable> temp = new AtomicReference<>();
		final AtomicReference<TradePersistable> copyTrade = new AtomicReference<>();
		
		TransactionUtil.doInJPA(entityManagerFactory, entityManager -> {
			temp.set(entityManager.find(TradePersistable.class, tradeId));
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery("SELECT MAX(id) FROM xtp_trade");
			int maxId = (Integer)query.getSingleResult();
			copyTrade.set(temp.get()); 
			copyTrade.get().setId(maxId+1);
			entityManager.persist(copyTrade);
			transaction.commit();
		});
		TradePersistableToDomainMapper mapedTrade = new TradePersistableToDomainMapper(copyTrade.get());
		return mapedTrade.PersistableToDomainMapper();
	}
	
}
