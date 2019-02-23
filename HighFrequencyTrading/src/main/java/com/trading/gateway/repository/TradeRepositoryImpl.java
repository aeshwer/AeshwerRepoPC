package com.trading.gateway.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.trading.commons.persistence.util.EntityManagerFactoryWrapper;
import com.trading.commons.persistence.util.HighFrequencyEntityManager;
import com.trading.commons.persistence.util.TransactionUtil;
import com.trading.commons.util.LogManagerUtil;
import com.trading.domain.trade.Trade;
import com.trading.domain.trade.TradeStatus;
import com.trading.gateway.jpa.persistable.PersistableTradeEntityModel;
import com.trading.gateway.jpa.persistable.TradePersistable;
import com.trading.gateway.repository.transformer.TradePersistableTransformer;

public class TradeRepositoryImpl implements TradeRepository{

	private static final Integer MAX_RESULT_SIZE = 100;
	private final EntityManagerFactoryWrapper entityManagerFactory;
	private final TradePersistableTransformer persistableTransformer;
	private static Logger logger;

	@Inject
	public TradeRepositoryImpl(@HighFrequencyEntityManager final EntityManagerFactoryWrapper entityManagerFactory,final TradePersistableTransformer persistableTransformer) {
		this.entityManagerFactory = entityManagerFactory;
		this.persistableTransformer = persistableTransformer;
		logger = LogManagerUtil.getLogger(TradeRepositoryImpl.class);

	}

	@Override
	public Trade persist(Trade trade) {
		final AtomicReference<PersistableTradeEntityModel> updatedEntityModel = new AtomicReference<>();
		final Optional<Long> tradeIdOptional = Optional.ofNullable(trade.getTradeId());
		try{
			TransactionUtil.doInJPA(logger,
					this.entityManagerFactory.getEntityManagerFactory(),
					entityManager -> {
						final EntityTransaction transaction = entityManager.getTransaction();
						transaction.begin();
						if (tradeIdOptional.isPresent()) {
							updatedEntityModel.set(this.updateTerm(entityManager, trade));
						} else {
							updatedEntityModel.set(this.createTerm(entityManager, trade));
						}
						transaction.commit();
						logger.info(TradeRepositoryImpl.class +":  Persist Request Success ");
					});
		}catch(Exception e)
		{
			updatedEntityModel.get().getTrade().setTradeStatus(TradeStatus.INVALID);
			logger.info(TradeRepositoryImpl.class + ":  Persist Failed");
		}
		updatedEntityModel.get().getTrade().setTradeStatus(TradeStatus.ACCECPTED);
		updatedEntityModel.get().getTrade().setTradeId(updatedEntityModel.get().getPersistable().getId());
		return updatedEntityModel.get().getTrade();
	}

	@Override
	public Trade findByTradeId(Long tradeId) {
		final AtomicReference<TradePersistable> fetchedTradePersistable = new AtomicReference<>();
		TransactionUtil.doInJPA(logger,this.entityManagerFactory.getEntityManagerFactory(), entityManager -> {
			fetchedTradePersistable.set(entityManager.find(TradePersistable.class, tradeId));
		});

		final Trade trade = this.persistableTransformer.createDomainFromPersistable(fetchedTradePersistable.get());
		return trade;
	}

	@Override
	public List<Trade> findTradeByCriteria(String fieldId, String filterText) {
		final List<Trade> tradeFetched = new ArrayList<>();
		final AtomicReference<List<TradePersistable>> fetchedTradePersistable = new AtomicReference<>();
		TransactionUtil.doInJPA(logger,this.entityManagerFactory.getEntityManagerFactory(), entityManager -> {

			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<TradePersistable> query = criteriaBuilder.createQuery(TradePersistable.class);
			final Root<TradePersistable> from = query.from(TradePersistable.class);
			query.select(from);
			query.where(this.preparePredicates(fieldId,filterText,criteriaBuilder,from));
			final TypedQuery<TradePersistable> selectQuery = entityManager.createQuery(query);
			selectQuery.setMaxResults(MAX_RESULT_SIZE);
			fetchedTradePersistable.set(selectQuery.getResultList());
		});
		for(TradePersistable  fetched: fetchedTradePersistable.get())
		{
			tradeFetched.add(this.persistableTransformer.createDomainFromPersistable(fetched));
		}
		return tradeFetched;
	}
	
	@Override
	public Trade copy(Trade copyTradeFromDb) {
		final TradePersistable tradePersistable = this.persistableTransformer.createPersistable(copyTradeFromDb);
		try{
			TransactionUtil.doInJPA(logger,
					this.entityManagerFactory.getEntityManagerFactory(),
					entityManager -> {
						final EntityTransaction transaction = entityManager.getTransaction();
						transaction.begin();
						entityManager.persist(tradePersistable);
						transaction.commit();
						logger.info(TradeRepositoryImpl.class +":  Copy Request Success and Persisted ");
					});
		}catch(Exception e)
		{
			logger.info(TradeRepositoryImpl.class + ":  Copy Trade Failed to Persist");
		}
		copyTradeFromDb.setTradeId(tradePersistable.getId());
		return copyTradeFromDb;
	}

	private Predicate[] preparePredicates(String fieldId, String filterText, CriteriaBuilder criteriaBuilder, Root<TradePersistable> root) {
		final List<Predicate> predicates = new ArrayList<>();
		predicates.add(criteriaBuilder.like(root.get(fieldId),filterText));
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private PersistableTradeEntityModel updateTerm(final EntityManager entityManager, final Trade trade) {
		PersistableTradeEntityModel entityModel = new PersistableTradeEntityModel();
		final TradePersistable tradePersistable = entityManager.find(TradePersistable.class, trade.getTradeId());
		this.persistableTransformer.updatePersistable(trade, tradePersistable );
		entityManager.persist(tradePersistable);
		entityModel.setPersistable(tradePersistable);
		entityModel.setTrade(trade);
		return entityModel;
	}

	private PersistableTradeEntityModel createTerm(final EntityManager entityManager, final Trade trade) {
		PersistableTradeEntityModel entityModel = new PersistableTradeEntityModel();
		final TradePersistable tradePersistable = this.persistableTransformer.createPersistable(trade);
		// XXX  Temporary Done Until a gud Id generation Mechanism is Implemented
		//this.persistableTransformer.generateIds(tradePersistable,trade);
		entityManager.persist(tradePersistable);
		entityModel.setPersistable(tradePersistable);
		entityModel.setTrade(trade);
		return entityModel;
	}

	@Override
	public Boolean deleteTrade(Long tradeId) {
		final AtomicReference<Boolean> isDeleted = new AtomicReference<>(false);
		try{
			TransactionUtil.doInJPA(logger,
					this.entityManagerFactory.getEntityManagerFactory(),
					entityManager -> {
						final EntityTransaction transaction = entityManager.getTransaction();
						transaction.begin();
						
						 final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
				            final CriteriaDelete<TradePersistable> criteriaDelete =
				                criteriaBuilder.createCriteriaDelete(TradePersistable.class);
				            final Root<TradePersistable> root =
				                criteriaDelete.from(TradePersistable.class);
				            criteriaDelete.where(
				                criteriaBuilder.equal(root.get("id"), tradeId));
				            isDeleted.set(
				                entityManager.createQuery(criteriaDelete).executeUpdate() == 1 ? true : false);
				            transaction.commit();
						logger.info(TradeRepositoryImpl.class +":  Delete Successful for tradeId" + tradeId);
					});
		}catch(Exception e)
		{
			logger.info(TradeRepositoryImpl.class + ":  Delete Operation Failed for tradeId" +tradeId);
		}
		return isDeleted.get();
	}
}