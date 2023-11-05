package com.food.controllers;

import java.util.List;
import java.util.Map;

import com.food.models.User;
import com.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping(value="/addnewusers")
	public User addUsers(@RequestBody User u) {
		return userService.createUser(u);
	}
	
	@PostMapping(value="/userlogin")
	 public Map<String, String> checkUser(@RequestBody User u) {
		 return userService.checkUser(u);
	 }
	
	
	@GetMapping(value="/users/{username}")
	public User getUsersByUsername(@PathVariable("username")String username) {
		return userService.getUserByUserName(username);
	}
	
	@GetMapping(value="/usersdata/{id}")
	public User getUsersByUserId(@PathVariable("id")Long id) {
		return userService.getUserById(id);
	}

	
	@GetMapping(value="/allusers")
	public List<User> allUsers(){
		return userService.getAllUser();
	}
}
