package com.trading.entryPoint.Function;

import com.trading.domain.trade.Trade;
import com.trading.services.TradeService;

public class TradeCaptureServiceImpl implements TradeCaptureService{
	
	private TradeService tradeService;

	@Override
	public void updateTrade(Trade trade) {
		
		//Extract Trade from Trade JSON
		tradeService.updateTrade(trade);
	}
	
	/*AsyncResult<TradeResponsePublishable> updatePhysicalTrade(
		      final String tradeJSON, final String viewId, final String locale);

		  AsyncResult<TradeResponsePublishable> validatePhysicalTrade(
		      final String currentTradeJSON,
		      final String oldTradeJSON,
		      final String viewId,
		      final String locale);

		  AsyncResult<String> getTradeDefaults(final @TalkParam(name = "viewId") String viewId);

		  AsyncResult<List<String>> fetchTrades(final String filterText);

		  AsyncResult<String> findTrade(final String tradeId, final String locale);

		  AsyncResult<String> copyTrade(
		      final String tradeId, final String locale);*/

}
