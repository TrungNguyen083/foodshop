package com.food.controllers;

import com.food.models.Balance;
import com.food.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BalanceController {
    @Autowired
    BalanceService balanceService;

    @PostMapping(value = "/addbalance")
    public void addBalance(@RequestBody Balance b) {
        balanceService.createBalance(b);
    }

    @PostMapping(value = "/updatebalance")
    public void updateBalance(@RequestBody Balance b) {
        balanceService.updateBalanceAmount(b);
    }

    @PostMapping(value = "/updateWithbalance")
    public void updateBalanceForWithdraw(@RequestBody Balance b) {
        balanceService.updateBalanceAmountForWithdraw(b);
    }

    @GetMapping(value = "/getbalance/{id}")
    public Balance getBalanceByUserId(@PathVariable("id") Long userId) {
        return balanceService.getBalanceByUserId(userId);
    }
}
