package com.food.service;

import com.food.models.Balance;
import com.food.repositories.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
	@Autowired
	BalanceRepository balanceRepository;

	public Balance createBalance(Balance balance) {
		return balanceRepository.save(balance);
	}

	public void updateBalanceAmount(Balance balance) {
		balanceRepository.updateBalancesAmount(balance.getAmount(), balance.getUser().getId());
	}

	public void updateBalanceAmountForWithdraw(Balance balance) {
		balanceRepository.updateBalancesAmountForWithdraw(balance.getAmount(), balance.getUser().getId());
	}

	public Balance getBalanceByUserId(Long userId) {
		return balanceRepository.findByUserId(userId);
	}
}
