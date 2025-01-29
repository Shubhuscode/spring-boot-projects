package com.pinnacle.social.post;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pinnacle.social.location.Location;
import com.pinnacle.social.user.User;

@Service
public class PostService {
	
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
			
			
		Post post1 = new Post(
			"p1",
			"31-Dec-24",
			user1,
		        "Wishing a happy new year in advance");
			
		Post post2 = new Post(
			"p2",
		        "30-Dec-24",
			user2,
			"Starting with Spring boot today");		
		
		
//	   List<Post> posts = Arrays.asList(post1, post2);
		List<Post> posts = new ArrayList<>(Arrays.asList(post1, post2));
		
	   public List<Post> getAllPosts() {
		return posts;
	   }
	   
	   public Post getPost(String id) {
	    	Post post = posts.stream()
			.filter(t -> id.equals(t.getId()))
			.findFirst()
			.orElse(null);
			
		return post;
	   }
	   
	   public void addPost(Post post) {
		     posts.add(post);
		}
	   
	   public void deletePost(String id) {
		     posts.removeIf(p -> p.getId().equals(id));		
		}
	   
	   public void updatePost(String id, Post post) {

		    for(int i = 0; i < posts.size(); i++) {

			Post p = posts.get(i);

			if(p.equals(post)) {

			     posts.set(i, post);
			}
		    }
		}

}
