package com.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.models.Provider;
import com.food.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    public Provider createProvider(Provider provider) {
    	return providerRepository.save(provider);
    }

    public Provider getProviderByUserName(String username) {
    	return providerRepository.findByShopUserName(username);
    }

    public Map<String, String> checkProvider(Provider sp) {
        Map<String, String> providerPass = new HashMap<>();
        providerPass.put("status", "Fail");

        Provider providerEntity = providerRepository.findByShopUserNameAndShopPassword(sp.getShopUserName(), sp.getShopPassword());

        if (providerEntity != null) {
            providerPass.put("status", "Success");
        }

        return providerPass;
    }
}
