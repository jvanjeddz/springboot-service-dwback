package com.backend.app.moneystore.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.backend.app.moneystore.client.CurrencyClientFeign;
import com.backend.app.moneystore.models.Store;

@Service("serviceFeign")
@Primary
public class StoreServiceFeign implements StoreService {

	@Autowired
	private CurrencyClientFeign clientFeign;
	
	@Override
	public List<Store> findAll() {
		return clientFeign.list().stream().map(p -> new Store(p, 5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		return new Store(clientFeign.detail(id), cantidad);
	}

}
