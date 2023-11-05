package com.food.service;

import java.util.List;

import com.food.models.Withdraw;
import com.food.repositories.WithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
	@Autowired
	WithdrawRepository withdrawRepository;

	public Withdraw createWithdraw(Withdraw withdraw){
		return withdrawRepository.save(withdraw);
	}

	public Withdraw getWithdrawById(Long withdrawId) {
		return withdrawRepository.findById(withdrawId).orElseThrow(
				() -> new RuntimeException("Withdraw not found with id : " + withdrawId)
		);
	}

	public Withdraw updateStatusWithdraw(Withdraw withdraw){
		Withdraw myWithdraw = getWithdrawById(withdraw.getId());
		myWithdraw.setStatus(withdraw.getStatus());
		return withdrawRepository.save(myWithdraw);
	}

	public List<Withdraw> getAllWithdraw(){
		return withdrawRepository.findAll();
	}
}
