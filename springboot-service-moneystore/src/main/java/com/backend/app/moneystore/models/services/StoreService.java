package com.backend.app.moneystore.models.services;

import java.util.List;

import com.backend.app.moneystore.models.Store;

public interface StoreService {
	
	public List<Store> findAll();
	public Store findById(Long id, Integer cantidad);
}
