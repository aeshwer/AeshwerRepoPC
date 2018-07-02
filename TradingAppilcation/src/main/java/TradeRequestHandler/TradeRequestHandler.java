package TradeRequestHandler;

import java.util.concurrent.Callable;

import com.google.inject.Inject;

import Domain.Trade;
import Util.TradeGateway;

public class TradeRequestHandler implements Callable<Trade>{

	private TradeGateway tradeGateway;

	private TradeRequest request;

	private int tradeId;

	@Inject
	public TradeRequestHandler(final TradeGateway tradeGateway ,final TradeRequest request, final int tradeId ) {
		this.tradeGateway = tradeGateway;
		this.request = request;
		this.tradeId = tradeId;
	}

	public Trade call() {
		Trade trade = null;
		switch(request.getRequestType()) 
		{
			case CREATE: 
			{
				tradeGateway.persist(request.getPersistable());break;
			}
			case FETCH:
			{
				trade = tradeGateway.findTradeById(tradeId);break;
			}
			case COPY:
			{
				trade = tradeGateway.copyTrade(tradeId);break;
			}
		}
		return trade;
	}
}
