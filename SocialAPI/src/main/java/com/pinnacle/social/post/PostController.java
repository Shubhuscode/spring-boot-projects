package com.pinnacle.social.post;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.pinnacle.social.location.Location;
import com.pinnacle.social.user.User;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;


@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/posts")
	public List<Post> getAllPosts() {
		
		return postService.getAllPosts();
	}
	
	@RequestMapping(value = "/posts/{id}")
	public Post getPost(@PathVariable String id) {
	    return postService.getPost( id);
	}
	
	@PostMapping("/add-posts")
	public void addPost(@RequestBody Post post) {
	     postService.addPost(post);
	}
	
	 @DeleteMapping("/posts/{id}")
	 public void deletePost(@PathVariable String id) {
	     postService.deletePost(id);
	 }
	 
	 @PutMapping("/posts/{id}")
	 public void updatePost(@PathVariable String id, @RequestBody Post post) {

	       postService.updatePost(id, post);

	 }
}
