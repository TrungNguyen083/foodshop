package com.food.repositories;

import com.food.models.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Query(value = "UPDATE BLANCE SET AMOUNT = AMOUNT+?1 WHERE user_id =?2", nativeQuery = true)
    public Balance updateBalancesAmount(double amount, Long userId);
    @Query(value = "UPDATE BLANCE SET AMOUNT = AMOUNT-?1 WHERE user_id =?2", nativeQuery = true)
    void updateBalancesAmountForWithdraw(double amount, Long userId);

    Balance findByUserId(Long userId);
}
