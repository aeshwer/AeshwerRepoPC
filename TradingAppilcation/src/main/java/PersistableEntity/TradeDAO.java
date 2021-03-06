package PersistableEntity;

import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.jboss.logging.Logger.Level;

import Domain.IPersistableEntity;
import Domain.Trade;
import Domain.TradePersistableToDomainMapper;
import PersistenceUtil.TransactionUtil;
import Util.LogManagerUtil;
import Util.TradeGateway;

public class TradeDAO /*extends GenericDAOManagerEntity*/ implements TradeGateway{

	//private GenericEntityManagerFactory genericEntityManagerFactory;

	//private	EntityManager entityManager;
	
	private EntityManagerFactory entityManagerFactory;
	
	private Logger logger ;

	public TradeDAO() {
		//this.genericEntityManagerFactory = genericEntityManagerFactory;	
		this.entityManagerFactory = HibernateEntityManageUtil.getEntityManagerFactory();
		this.logger =  LogManagerUtil.getLogger(TradeDAO.class);
	}

	public void persist(IPersistableEntity persistable) {
		//super.Perist(persistable);
		TransactionUtil.doInJPA(logger, entityManagerFactory, entityManager -> {
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist((TradePersistable)persistable);
			transaction.commit();
			logger.info("Persist Success: TradeId: "+ ((TradePersistable) persistable).getId());
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
		TransactionUtil.doInJPA(logger,entityManagerFactory, entityManager -> {
			temp.set(entityManager.find(TradePersistable.class, tradeId));
		});
		TradePersistableToDomainMapper mapedTrade = new TradePersistableToDomainMapper(temp.get());
		return mapedTrade.PersistableToDomainMapper();
	}

	// Reference : https://www.boraji.com/hibernate-5-criteria-query-example
	@Override
	public Trade copyTrade(int tradeId) {
		final AtomicReference<TradePersistable> temp = new AtomicReference<>();
		final AtomicReference<Integer> maxId = new AtomicReference<>();
		
		TransactionUtil.doInJPA(logger,entityManagerFactory, entityManager -> {
			temp.set(entityManager.find(TradePersistable.class, tradeId));
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		    final CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
		    final Root<TradePersistable> root = criteriaQuery.from(TradePersistable.class);
		    criteriaQuery.select(criteriaBuilder.max(root.get("id")));
	        final TypedQuery<Integer> query = entityManager.createQuery(criteriaQuery);
	        maxId.set(query.getResultList().get(0));
	        logger.info("MaxId Retrived"+ maxId.get());
			transaction.commit();
		});
		TradePersistable copyTrade = temp.get();
		copyTrade.setId(maxId.get()+1);
		TradePersistableToDomainMapper mapedTrade = new TradePersistableToDomainMapper(copyTrade);
		//persist now
		this.persist(copyTrade);
		return mapedTrade.PersistableToDomainMapper();
	}
	
}
