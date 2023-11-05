package com.food.repositories;

import com.food.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    @Query("SELECT p FROM Provider p WHERE p.shopUserName = ?1")
    Provider findByShopUserName(String username);

    @Query("SELECT p FROM Provider p WHERE p.shopUserName = ?1 AND p.shopPassword = ?2")
    Provider findByShopUserNameAndShopPassword(String shopUserName, String shopPassword);
}
