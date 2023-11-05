package com.food.service;

import java.util.HashMap;
import java.util.Map;

import com.food.models.Admin;
import com.food.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Map<String, String> checkAdmin(Admin a1) {
        HashMap<String, String> hash = new HashMap<>();

        try {
            Admin admin = adminRepository.findByUsernameAndPassword(a1.getUsername(), a1.getPassword());

            if (admin != null) {
                hash.put("status", "success");
            }
        } catch (Exception e) {
            hash.put("status", "Fail");
        }

        return hash;
    }

    public Admin getAdminByUserName(String username) {
        try {
            return adminRepository.findByUsername(username);
        } catch (Exception e) {
            throw new RuntimeException("Admin not found with username : " + username);
        }
    }
}
