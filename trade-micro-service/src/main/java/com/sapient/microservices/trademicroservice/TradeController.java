package com.sapient.microservices.trademicroservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

	@Autowired
	public TradingServiceProxy tradingServiceProxy;
	
	@Autowired
	public TradingDao tradingdao;
	
	@GetMapping("/trade")
	public List<TradeBean> buyTrade() {
		//List<TradeBean> list = new ArrayList<>();
		return tradingdao.getAllTarde();
		
	}
	
	@PostMapping("/addtrade")
	public String addTrade(@RequestBody TradeBean tradebean) {
		
		tradebean.setMarketPrice(tradingServiceProxy.getprice(tradebean.getCommodities()).getMarketPrice());
		tradingdao.saveTrade(tradebean);
		return "Successfully added trade";
		
	}
}
