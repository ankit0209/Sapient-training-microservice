package com.sapient.microservices.trademicroservice;

import java.util.List;

import org.springframework.stereotype.Component;

public interface TradingDao {

	public List<TradeBean> getAllTarde();
	
	public int saveTrade(TradeBean tradebean);
	public TradeBean findOne(int id);
}
