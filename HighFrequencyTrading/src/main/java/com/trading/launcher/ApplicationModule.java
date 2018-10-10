package com.trading.launcher;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.trading.commons.util.EntityManagerFactoryWrapper;
import com.trading.commons.util.HighFrequencyEntityManagerFactory;
import com.trading.commons.util.HighFrequencyTradingPersistence;
import com.trading.entryPoint.Function.ExposedTradeFunction;
import com.trading.entryPoint.Function.TradeCaptureService;
import com.trading.entryPoint.Function.TradeCaptureServiceImpl;
import com.trading.gateway.HighFrequencyTradeGatewayImpl;
import com.trading.gateway.PrePersistProcessingManager;
import com.trading.gateway.TradeFetchService;
import com.trading.gateway.TradeFetchServiceImpl;
import com.trading.gateway.TradeGateway;
import com.trading.gateway.TradePersistService;
import com.trading.gateway.TradePersistServiceImpl;
import com.trading.gateway.repository.TradeRepository;
import com.trading.gateway.repository.TradeRepositoryImpl;
import com.trading.gateway.repository.transformer.TradePersistableTransformer;
import com.trading.gateway.repository.transformer.TradePersistableTransformerImpl;
import com.trading.services.TradeService;
import com.trading.services.TradeServiceImpl;
import com.trading.validation.TradeValidationService;
import com.trading.validation.TradeValidationServiceImpl;

public class ApplicationModule extends AbstractModule{

	@Override
	protected void configure() {
		this.bind(TradeService.class).to(TradeServiceImpl.class);
		this.bind(EntityManagerFactoryWrapper.class).annotatedWith(HighFrequencyTradingPersistence.class).to(HighFrequencyEntityManagerFactory.class);
		this.bind(TradeCaptureService.class).to(TradeCaptureServiceImpl.class);
		this.bind(TradeRepository.class).to(TradeRepositoryImpl.class).in(Singleton.class);
	    this.bind(TradeGateway.class).to(HighFrequencyTradeGatewayImpl.class);
	    this.bind(TradeValidationService.class).to(TradeValidationServiceImpl.class);
	    this.bind(TradePersistService.class).to(TradePersistServiceImpl.class);
	    this.bind(TradeFetchService.class).to(TradeFetchServiceImpl.class);
	    this.bind(TradePersistableTransformer.class).to(TradePersistableTransformerImpl.class);
	    
	    this.bind(PrePersistProcessingManager.class);
	    //this.bind(ExposedTradeFunction.class);//Temporary until we wire up the UI Code
	}
}
