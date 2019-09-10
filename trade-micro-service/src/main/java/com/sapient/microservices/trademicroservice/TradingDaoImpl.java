package com.sapient.microservices.trademicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TradingDaoImpl implements TradingDao{

static List<TradeBean> list = new ArrayList<>();
	
	static {
		list.add(new TradeBean("Lorem","London","Aluminum",1560));
		list.add(new TradeBean("Ipsum","Singapore","Singapore",1345));
		list.add(new TradeBean("Dolor","Denver","Copper",1289));
	}
	@Override
	public List<TradeBean> getAllTarde() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public void saveTrade(TradeBean tradebean) {
		// TODO Auto-generated method stub
		list.add(tradebean);
		
		
	}

}
