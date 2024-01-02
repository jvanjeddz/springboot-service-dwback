package com.backend.app.moneystore.models;

public class Store {
	private Dwback currency;
	private Integer cantidad;
	
	public Store()	{
		
	}
	
	public Store(Dwback currency, Integer cantidad) {
		this.currency = currency;
		this.cantidad = cantidad;
	}
	
	public Dwback getCurrency() {
		return currency;
	}
	public void setCurrency(Dwback currency) {
		this.currency = currency;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
//	public Double getTotal()	{
//		return product.getPrice() * cantidad.doubleValue();
//	}
}
