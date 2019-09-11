package com.sapient.microservices.trademicroservice;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public List<TradeBean> getAllTrade() {
		//List<TradeBean> list = new ArrayList<>();
		return tradingdao.getAllTarde();
		
	}

	@GetMapping("/trade/{id}")
	public TradeBean getTarde(@PathVariable int id){

		return tradingdao.findOne(id);

	}
	@PostMapping("/addtrade")
	public String addTrade(@RequestBody TradeBean tradebean) {
		
		tradebean.setMarketPrice(tradingServiceProxy.getprice(tradebean.getCommodities()).getMarketPrice());
		tradingdao.saveTrade(tradebean);
		return "Successfully added trade";
		
	}
	

	
	  @PostMapping("/addtradetoqueuqe") public Resource<TradeResponse>
	  addTradetoqueue(@RequestBody TradeBean tradebean) {
	  
	  tradebean.setMarketPrice(tradingServiceProxy.getprice(tradebean.
	  getCommodities()).getMarketPrice());
	  this.jmsTemplate.convertAndSend(this.queue,tradebean);
	  tradingdao.saveTrade(tradebean);
	  TradeResponse tradeResponse = new TradeResponse("Success");
	  Resource<TradeResponse> resource = new Resource<TradeResponse>(tradeResponse);
	  ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getTarde(1));

		resource.add(linkTo.withRel("trade-link"));		

		return resource;
	  
	  
	  }
	  
	 
  
  }
 
