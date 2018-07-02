package Util;

import com.google.inject.Inject;

public class TradeRequestHandler implements Runnable{

	private TradeGateway tradeGateway;
	
	private TradeRequest request;
	
	private int tradeId;

	@Inject
	public TradeRequestHandler(final TradeGateway tradeGateway ,final TradeRequest request, final int tradeId ) {
		this.tradeGateway = tradeGateway;
		this.request = request;
		this.tradeId = tradeId;
	}

	public void run() {
		this.handelRequest();
	}

	private void handelRequest()
	{
		switch(request.getRequestType()) 
		{
		case CREATE: 
			{
			tradeGateway.persist(request.getPersistable());break;
			}
		case UPDATE:
			{
			tradeGateway.updateTrade(tradeId);break;
			}
		case FETCH:
			{
			tradeGateway.findTradeById(tradeId);break;
			}
		default:
		}
	}
}
