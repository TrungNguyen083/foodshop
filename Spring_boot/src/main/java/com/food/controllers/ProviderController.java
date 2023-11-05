package com.food.controllers;

import java.util.List;
import java.util.Map;

import com.food.models.Provider;
import com.food.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProviderController {
	@Autowired
	ProviderService providerService;
	
	
	@PostMapping(value="/addshop")
	public Provider shopAdd(@RequestBody Provider sp) {
		return providerService.createProvider(sp);
	}
	
	@PostMapping(value="/shoplogin")
	public Map<String, String> checkProvider(@RequestBody Provider p){
		return providerService.checkProvider(p);
	}
	
	@GetMapping(value="/shops/{username}")
	public Provider getProviderByUserName(@PathVariable("username")String username) {
		return providerService.getProviderByUserName(username);
	}
	
	@GetMapping(value ="/allproviders")
	public List<Provider> allProviders(){
		return providerService.getAllProviders();
	}
	
}
