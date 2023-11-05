package com.food.controllers;

import java.util.List;

import com.food.models.Withdraw;
import com.food.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WithdrawController {
    @Autowired
    WithdrawService withdrawService;

    @PostMapping(value = "/addwithdraw")
    public Withdraw addWithdraw(@RequestBody Withdraw w) {
        return withdrawService.createWithdraw(w);
    }

    @PostMapping(value = "/updatewithdraw")
    public Withdraw updateWithdraw(@RequestBody Withdraw w) {
        return withdrawService.updateStatusWithdraw(w);
    }

    @GetMapping(value = "/getwithdraw")
    public List<Withdraw> getWithdraw() {
        return withdrawService.getAllWithdraw();
    }

}
