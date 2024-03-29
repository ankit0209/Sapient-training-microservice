package com.sapient.microservice.model;

//counterparties, commodities ,location and market price
public class TradeBean {
	
	private String counterParty;
	
	private String location;
	
	private String commodities;
	
	private int marketPrice;
	
	private int id;
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TradeBean() {
		
	}
	
	public TradeBean(int id,String counterParty, String location, String commodities, int marketPrice) {
		super();
		this.id=id;
		this.counterParty = counterParty;
		this.location = location;
		this.commodities = commodities;
		this.marketPrice = marketPrice;
	}

	public String getCounterParty() {
		return counterParty;
	}

	public void setCounterParty(String counterParty) {
		this.counterParty = counterParty;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCommodities() {
		return commodities;
	}

	public void setCommodities(String commodities) {
		this.commodities = commodities;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	

}
