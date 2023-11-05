package com.food.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.food.models.User;
import com.food.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User createUser(User user){
		return userRepository.save(user);
	}

	public Map<String, String> checkUser(User u1) {
		Map<String, String> userPass = new HashMap<>();
		userPass.put("status", "Fail");

		User user = userRepository.findByUsernameAndUserPassword(u1.getUsername(), u1.getPassword());

		if (user != null) {
			userPass.put("status", "Success");
		}

		return userPass;
	}

	public User getUserByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	public User getUserById(Long userId) {
		return userRepository.findById(userId).orElseThrow(
				() -> new RuntimeException("User not found with id : " + userId)
		);
	}

	public List<User> getAllUser(){
		return userRepository.findAll();
	}
}
