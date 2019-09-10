package com.sapient.microservices.trademicroservice;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface TradingDao {

	public List<TradeBean> getAllTarde();
	
	public void saveTrade(TradeBean tradebean);
}
