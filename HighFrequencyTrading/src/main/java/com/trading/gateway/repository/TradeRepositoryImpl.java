package com.trading.gateway.repository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.trading.commons.util.EntityManagerFactoryWrapper;
import com.trading.commons.util.HighFrequencyTradingPersistence;
import com.trading.commons.util.LogManagerUtil;
import com.trading.commons.util.TransactionUtil;
import com.trading.domain.trade.Trade;
import com.trading.gateway.jpa.persistable.TradePersistable;
import com.trading.gateway.repository.transformer.TradePersistableTransformer;

public class TradeRepositoryImpl implements TradeRepository{

	private final EntityManagerFactoryWrapper entityManagerFactory;
	private final TradePersistableTransformer persistableTransformer;
	private static Logger logger;
	
	@Inject
	public TradeRepositoryImpl(@HighFrequencyTradingPersistence final EntityManagerFactoryWrapper entityManagerFactory,final TradePersistableTransformer persistableTransformer) {
		this.entityManagerFactory = entityManagerFactory;
		this.persistableTransformer = persistableTransformer;
		logger = LogManagerUtil.getLogger(TradeRepositoryImpl.class);
		
	}

	@Override
	public Trade persist(Trade trade) {
		final AtomicReference<Trade> updatedTrade = new AtomicReference<>();
		final Optional<String> tradeIdOptional = Optional.ofNullable(trade.getTradeId());
		TransactionUtil.doInJPA(logger,
		        this.entityManagerFactory.getEntityManagerFactory(),
		        entityManager -> {
		          final EntityTransaction transaction = entityManager.getTransaction();
		          transaction.begin();
		          if (tradeIdOptional.isPresent()) {
		            updatedTrade.set(this.updateTerm(entityManager, trade));
		          } else {
		            updatedTrade.set(this.createTerm(entityManager, trade));
		          }
		          transaction.commit();
		          logger.info("Persist Success:"+ trade.getTradeId());
		        });
		    return updatedTrade.get();
	}
	
	  private Trade updateTerm(final EntityManager entityManager, final Trade trade) {
		   /*final TradePersistable tradePersistable = entityManager.find(TradePersistable.class, trade.getId());
		   this.persistableTransformer.updatePersistable(trade, tradePersistable );

		    final TradeHeaderPersistable tradeHeaderPersistable = tradePersistable.getTradeHeader();
		    tradePersistable.setData(trade);
		    tradeHeaderPersistable.setData(trade.getTradeHeader());

		    this.persistTerm(entityManager, tradePersistable, tradeHeaderPersistable);
		    return trade;*/
		  return new Trade();
		  }
	  
	  private Trade createTerm(final EntityManager entityManager, final Trade trade) {
		    final TradePersistable tradePersistable = this.persistableTransformer.createPersistable(trade);
		    this.persistableTransformer.generateIds(tradePersistable,entityManager);
		    entityManager.persist(tradePersistable);
		    return trade;
		  }
}