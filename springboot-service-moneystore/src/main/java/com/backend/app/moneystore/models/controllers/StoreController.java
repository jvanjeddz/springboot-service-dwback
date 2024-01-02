package com.backend.app.moneystore.models.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.moneystore.models.Dwback;
import com.backend.app.moneystore.models.Store;
import com.backend.app.moneystore.models.services.StoreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StoreController {
	
	@Autowired
	//se planea trabajar con @Primary
	//@Qualifier("serviceRest")
	private StoreService storeService;
	
	@GetMapping("/list")
	public List<Store> list(){
		return storeService.findAll();
	}
	
	@HystrixCommand(fallbackMethod="justAGenericMethod")
	@GetMapping("/dwback/{id}/cantidad/{cantidad}")
	public Store details(@PathVariable Long id, @PathVariable Integer cantidad) {
		return storeService.findById(id, cantidad);
	}
	
	public Store justAGenericMethod(Long id, Integer cantidad) {
		Store store = new Store();
		Dwback cur = new Dwback(id, "Not an actual currency", "Not an actual country");
		store.setCantidad(cantidad);
		store.setCurrency(cur);
		
		return store;
	}

}
