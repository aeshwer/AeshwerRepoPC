package com.trading.gateway;

import java.util.List;

import com.trading.domain.trade.Trade;

public interface TradeFetchService {

	Trade findTrade(final Long tradeId);

	List<Trade> fetchTrade(String fieldId, String filterText);

}
