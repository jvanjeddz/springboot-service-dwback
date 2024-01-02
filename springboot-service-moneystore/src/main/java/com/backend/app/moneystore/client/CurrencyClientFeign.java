package com.backend.app.moneystore.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.app.moneystore.models.Dwback;


@FeignClient(name = "service-dwback")
public interface CurrencyClientFeign {
	
	@GetMapping("/list")
	public List<Dwback> list();
	
	@GetMapping("/dwback/{id}")
	public Dwback detail(@PathVariable Long id);
	
	

}
