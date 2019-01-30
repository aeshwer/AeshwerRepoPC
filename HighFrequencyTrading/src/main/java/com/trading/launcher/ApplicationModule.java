package com.trading.launcher;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.trading.commons.persistence.util.DatabaseConfigUtil;
import com.trading.commons.persistence.util.Config;
import com.trading.commons.persistence.util.EntityManagerFactoryWrapper;
import com.trading.commons.persistence.util.HighFrequencyEntityManager;
import com.trading.commons.persistence.util.HighFrequencyEntityManagerFactory;
import com.trading.commons.util.ReadDatabseConfigXMLFile;
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
import com.trading.gateway.downstream.HighFrequencyTradeCapturePostOperationNotifier;
import com.trading.gateway.repository.TradeRepository;
import com.trading.gateway.repository.TradeRepositoryImpl;
import com.trading.gateway.repository.transformer.SequenceNumberGenerator;
import com.trading.gateway.repository.transformer.TradePersistableTransformer;
import com.trading.gateway.repository.transformer.TradePersistableTransformerImpl;
import com.trading.services.TradeService;
import com.trading.services.TradeServiceImpl;
import com.trading.validation.TradeValidationService;
import com.trading.validation.TradeValidationServiceImpl;

public class ApplicationModule extends AbstractModule {

	@Override
	protected void configure() {
		this.install(new JMSConnectionModule());
		this.bind(TradePersistableTransformer.class).to(TradePersistableTransformerImpl.class);
		this.bind(TradeRepository.class).to(TradeRepositoryImpl.class).in(Singleton.class);
		this.bind(PrePersistProcessingManager.class);
		this.bind(SequenceNumberGenerator.class);
		this.bind(HighFrequencyTradeCapturePostOperationNotifier.class);
		this.bind(TradeFetchService.class).to(TradeFetchServiceImpl.class);

		this.bind(TradePersistService.class).to(TradePersistServiceImpl.class);
		this.bind(TradeGateway.class).to(HighFrequencyTradeGatewayImpl.class);
		this.bind(TradeValidationService.class).to(TradeValidationServiceImpl.class);
		this.bind(TradeService.class).to(TradeServiceImpl.class);
		this.bind(TradeCaptureService.class).to(TradeCaptureServiceImpl.class);

		this.bind(ExposedTradeFunction.class);// Temporary until we wire up the UI Code
		this.bind(HighFrequencyTradingMain.class);
		this.bind(DatabaseConfigUtil.class);
		this.bind(ReadDatabseConfigXMLFile.class);
	}

	@Provides
	@Singleton
	@HighFrequencyEntityManager
	@Inject
	public EntityManagerFactoryWrapper getEntityManagerFactory(final ReadDatabseConfigXMLFile configXMLFile,
			final DatabaseConfigUtil databaseConfigUtil) {

		Config config = configXMLFile.parseConfigXMLToConfigObject();

		final Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.jdbc.driver", databaseConfigUtil.getDriver(config.getDBType()));
		properties.put("javax.persistence.jdbc.url", databaseConfigUtil.getDatabaseUrl(config.getDBType(),
				config.getDBHost(), config.getDBPort(), config.getServiceName(), config.getInstanceName()));
		properties.put("hibernate.connection.username", config.getDBUser());
		properties.put("hibernate.connection.password", config.getDBPassword());
		properties.put("hibernate.dialect", databaseConfigUtil.getDialect(config.getDBType()));

		return new HighFrequencyEntityManagerFactory("HighFrequencyTradeUnit", properties);
	}
}
