package com.pinnacle.social.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pinnacle.social.location.Location;

@Service
public class UserService {
	
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
			
//	   private List<User> users = Arrays.asList(user1, user2);	
		private List<User> users = new ArrayList<>(Arrays.asList(user1, user2));
		
	   public List<User> getAllUsers() {
		return users;
	   }

	   public User getUser(String id) {
		   User user = users.stream()
				   .filter(t -> id.equals(t.getId()))
				   .findFirst()
				   .orElse(null);
		   
		   return user;
	   }
	   
	   public void addUser(User user) {
		    users.add(user);
		}
	   
	   public void deleteUser(String id) {
		     users.removeIf(u -> u.getId().equals(id));		
		}
	   
	   public void updateUser(String id, User user) {

		    for(int i = 0; i < users.size(); i++) {

			User u = users.get(i);

			if(u.getId().equals(id)) {

			     users.set(i, user);

			     return;
			}
		    }
		}
}


