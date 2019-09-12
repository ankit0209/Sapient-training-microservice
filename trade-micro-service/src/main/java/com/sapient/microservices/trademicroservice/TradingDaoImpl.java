package com.sapient.microservices.trademicroservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.microservice.model.TradeBean;

@Component
public class TradingDaoImpl implements TradingDao{

static List<TradeBean> list = new ArrayList<>();
static {
		list.add(new TradeBean(1,"Lorem","London","Aluminum",1560));
		list.add(new TradeBean(2,"Ipsum","Singapore","Singapore",1345));
		list.add(new TradeBean(3,"Dolor","Denver","Copper",1289));
	}
 
	@Override
	public List<TradeBean> getAllTarde() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public int saveTrade(TradeBean tradebean) {
		
		// TODO Auto-generated method stub
		int count = list.size();
		
		if (tradebean.getId() == 0) {

			tradebean.setId(++count);

		}

		list.add(tradebean);

		return tradebean.getId();
		
		
		
	}
	public TradeBean findOne(int id) {

		for (TradeBean tradeBean : list) {

			if (id == tradeBean.getId())

				return tradeBean;

		}

		return null;

	}
}
