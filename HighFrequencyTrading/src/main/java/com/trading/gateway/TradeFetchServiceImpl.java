package com.trading.gateway;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.math.NumberUtils;

import com.google.inject.Inject;
import com.trading.domain.trade.Trade;
import com.trading.gateway.repository.TradeRepository;

public class TradeFetchServiceImpl implements TradeFetchService {

	private final TradeRepository tradeRepository;

	@Inject
	public TradeFetchServiceImpl(final TradeRepository tradeRepository) {
		this.tradeRepository = tradeRepository;
	}

	@Override
	public Trade findTrade(Long tradeId) {
		Validate.notNull(tradeId, "Trade Id cannot be null.");
		Validate.isTrue(NumberUtils.isNumber(tradeId.toString()), "Trade id is not a number.");
		final Trade trade = this.tradeRepository.findByTradeId(tradeId);
		return trade;
	}

	@Override
	public Trade fetchTrade(String fieldId, String filterText) {
		Validate.notNull(fieldId, " fieldId cannot be null.");
		final Trade trade = this.tradeRepository.findTradeByCriteria(fieldId,filterText);
		return null;
	}
}