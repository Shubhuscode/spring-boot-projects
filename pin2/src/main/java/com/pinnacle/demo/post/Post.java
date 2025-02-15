package com.pinnacle.demo.post;

import com.pinnacle.demo.user.User;

public class Post {
	public Post(String id, String postdate, User user, String details) {
		this.id = id;
		this.postdate = postdate;
		this.user = user;
		this.details = details;
	}

	private String id;
	private String postdate;
	private User user;
	private String details;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostdate() {
		return postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
