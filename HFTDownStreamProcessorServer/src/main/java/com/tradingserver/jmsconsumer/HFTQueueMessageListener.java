package com.tradingserver.jmsconsumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.apache.log4j.Logger;

import com.trading.util.LogManagerUtil;
import com.trading.util.TradeConstant;

public class HFTQueueMessageListener implements MessageListener{

	private static final String consumerName = HFTQueueMessageListener.class.getName();

	private final static Logger logger = LogManagerUtil.getLogger(HFTQueueMessageListener.class);

	public HFTQueueMessageListener() {
	}

	@Override
	public void onMessage(Message message){
		String textMessage = null;
		try {
			textMessage = this.createTradeReceived(message);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("[ "+ consumerName + "] Trade Received on DownStreamServer is recieved........" +textMessage);
	}

	private String createTradeReceived(Message message) throws JMSException 
	{
		return "[  TradeId: "+ message.getStringProperty(TradeConstant.TRADE_ID)+ " ,TradeStatus:  " + message.getStringProperty(TradeConstant.TRADE_STATUS)+  "  ,TradeDate:  " + message.getStringProperty(TradeConstant.TRADE_DATE)+  " ]";
	}
}
