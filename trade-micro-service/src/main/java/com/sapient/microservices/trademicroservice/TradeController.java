package com.sapient.microservices.trademicroservice;


import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TradeController {

	@Autowired
	public TradingServiceProxy tradingServiceProxy;
	
	@Autowired
	public TradingDao tradingdao;
	
	@Autowired
	private JmsTemplate jmsTemplate;
 
	@Value("${jsa.activemq.queue}")
	private String queue;
	
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
	
	@PostMapping("/addtradetoqueuqe")
	public String addTradetoqueue(@RequestBody TradeBean tradebean) {
		
		tradebean.setMarketPrice(tradingServiceProxy.getprice(tradebean.getCommodities()).getMarketPrice());
		//this.jmsTemplate.convertAndSend(this.queue, "1");
		tradingdao.saveTrade(tradebean);
		return "Successfully added trade";
		
	}

	
	  @PostMapping("/addtradetoqueuqe1") public String
	  addTradetoqueue1(@RequestBody TradeBean tradebean) {
	  
	  tradebean.setMarketPrice(tradingServiceProxy.getprice(tradebean.
	  getCommodities()).getMarketPrice());
	  this.jmsTemplate.convertAndSend(this.queue,tradebean);
	  tradingdao.saveTrade(tradebean); return "Successfully added trade";
	  
	  }
	  
	 
  
  }
 
