package com.pinnacle.social;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController {
	@RequestMapping(value="/welcome")
	public static String welcome() {
		return "Welcome to Spring Boot";
	}
	

}
