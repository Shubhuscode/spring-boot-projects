package posts;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class postsController {
	@RequestMapping(value = "/posts")
	   public List<Post> getAllPosts() {
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
			
		return Arrays.asList(post1, post2);
	 
	   }

}
