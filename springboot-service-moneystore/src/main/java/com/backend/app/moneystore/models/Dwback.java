package com.backend.app.moneystore.models;


public class Dwback {

	private Long id;
	
	private String currency;
	
	private String country;
	
	private Integer port;
	
	public Dwback(Long id, String currency, String country)	{
		this.id = id;
		this.currency = currency;
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
}
