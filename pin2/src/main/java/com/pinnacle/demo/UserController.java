package com.pinnacle.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pinnacle.demo.location.Location;
import com.pinnacle.demo.user.User;

@RestController
public class UserController {
	
	@RequestMapping(value="/users")
	   public List<User> getAllUsers() {
		User user1 = new User(
			"u1", 
			"Ramesh", 
			"Sharma",
			new Location("l1", "New York"),
			"Ramesh@gmail.com");
			
		User user2 = new User(
			"u2", 
			"Mahesh", 
			"Kapoor",
			new Location("l2", "Delhi"),
			"Mahesh@gmail.com");
			
		return Arrays.asList(user1, user2);	
		
	}

}
