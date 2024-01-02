package com.backend.app.moneystore.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.moneystore.models.Dwback;
import com.backend.app.moneystore.models.Store;

@Service("serviceRest")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private RestTemplate clientRest;
	@Override
	public List<Store> findAll() {
		List<Dwback> numCurrencies = Arrays.asList(clientRest.getForObject("http://localhost:8002/list", Dwback[].class));
		return numCurrencies.stream().map(p -> new Store(p, 5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Dwback currency = clientRest.getForObject("http://localhost:8002//dwback/{id}", Dwback.class, pathVariables);
		
		return new Store(currency, cantidad);
	}

}
