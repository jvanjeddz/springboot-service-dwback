package com.springboot.backend.app.dwback.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.app.dwback.models.entity.Dwback;
import com.springboot.backend.app.dwback.models.service.DwbackService;

@RestController
public class DwbackController {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private DwbackService backService;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")
	public List<Dwback> list(){
		
		return backService.findAll().stream().map(cur -> {
			cur.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return cur;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/dwback/{id}")
	public Dwback detail(@PathVariable Long id) {
		
//		try	{
//			Thread.sleep(2000L);
//		}catch(InterruptedException e)	{
//			e.printStackTrace();
//		}
//		boolean bl = false;
//		if(!bl) {
//			throw new RuntimeException("No se pudo obtener el detalle de dicha moneda");
//		}
		return backService.findById(id);
	}
	

	@DeleteMapping("/dwback/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id){
		backService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PostMapping("/dwback")
	public ResponseEntity<Dwback> add(@RequestBody Dwback instance) {
		Dwback addCur = backService.create(instance);
		return new ResponseEntity<>(addCur, HttpStatus.CREATED);
    }
	
	
	@PutMapping("/dwback/{id}")
	public ResponseEntity<Dwback> update(@PathVariable Long id, @RequestBody Dwback instance){
		if(backService.existsById(id)) {
			instance.setId(id);
			Dwback updateCur = backService.create(instance);
			return new ResponseEntity<>(updateCur, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
}