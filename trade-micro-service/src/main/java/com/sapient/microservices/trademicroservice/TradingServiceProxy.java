package com.sapient.microservices.trademicroservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sapient.microservice.model.TradeBean;

@FeignClient(name="netflix-zull-gateway-server")

@RibbonClient(name="market-data-service")
public interface TradingServiceProxy {

	@GetMapping("/market-data-service/price/{metalName}")
	public TradeBean getprice(@PathVariable String metalName);
}
