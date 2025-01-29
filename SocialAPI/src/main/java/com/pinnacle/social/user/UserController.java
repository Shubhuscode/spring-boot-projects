package com.pinnacle.social.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pinnacle.social.location.Location;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users")
	public List<User> getAllUsers() {

		return userService.getAllUsers();	
	}
	
	@RequestMapping(value = "/users/{id}")
	public User getUser(@PathVariable String id) {
	    return userService.getUser(id);
	}
	
	@PostMapping("/add-users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	 @DeleteMapping("/users/{id}")
	 public void deleteUser(@PathVariable String id) {
	      userService.deleteUser(id);
	 }
	 @PutMapping("/users/{id}")
	 public void getUser(@PathVariable String id, @RequestBody User user) {

	     userService.updateUser(id, user);

	 }

}
