package com.food.controllers;

import java.util.Map;

import com.food.models.Admin;
import com.food.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/addadmin")
    public Admin saveAdmin(@RequestBody Admin a) {
        return adminService.createAdmin(a);
    }

    @PostMapping(value = "/adminlogin")
    public Map<String, String> checkAdmin(@RequestBody Admin a) {
        return adminService.checkAdmin(a);
    }

    @GetMapping(value = "/admin/{username}")
    public Admin getAdminByUserName(@PathVariable("username") String username) {
        return adminService.getAdminByUserName(username);
    }

}
