package PersistableEntity;


import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import Domain.IPersistableEntity;
import Domain.Trade;
import PersistenceUtil.TransactionUtil;
import Util.LogManagerUtil;
import Util.TradeGateway;

public class TradeDetailDAO implements TradeGateway {

	private EntityManagerFactory entityManagerFactory;

	private Logger logger ;

	public TradeDetailDAO() {
		this.entityManagerFactory = HibernateEntityManageUtil.getEntityManagerFactory();
		this.logger =  LogManagerUtil.getLogger(TradeDAO.class);
	}

	public void persist(IPersistableEntity persistable) {
		TransactionUtil.doInJPA(logger, entityManagerFactory, entityManager -> {
			final EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(persistable);
			transaction.commit();
			logger.info("Persist Success: TradeDetail Id: "+ ((TradeDetailsPersistable) persistable).getDetailId());
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
