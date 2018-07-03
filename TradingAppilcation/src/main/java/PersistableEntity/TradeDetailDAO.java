package PersistableEntity;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import Domain.Trade;
import PersistenceUtil.TransactionUtil;
import Util.LogManagerUtil;
import Util.TradeGateway;

public class TradeDetailDAO implements TradeGateway {

	private EntityManagerFactory entityManagerFactory;

	private Logger logger ;

	public TradeDetailDAO() {
		this.entityManagerFactory = HibernateEntityManageUtil.getEntityManager();
		this.logger =  LogManagerUtil.getLogger(TradeDAO.class);
	}

	public void persist(TradePersistable persistable) {
		TransactionUtil.doInJPA(logger, entityManagerFactory, entityManager -> {
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(persistable);
			transaction.commit();
			logger.info("Persist Success: TradeId: "+ persistable.getId());
		});
	}

	@Override
	public Trade findTradeById(int tradeId) {
		return null;
	}

	@Override
	public Trade copyTrade(int tradeId) {
		return null;
	}

}
