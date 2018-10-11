package com.trading.gateway.repository.transformer;

import java.util.UUID;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.trading.gateway.jpa.persistable.TradePersistable;

public class SequenceNumberGenerator {

	@Inject
	public SequenceNumberGenerator() {
	}

	public void generate(EntityManager entityManager, TradePersistable tradePersistable) {
		//tradePersistable.setId(UUID.randomUUID().toString());
	}
}
