package com.raghava.oauth.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
	
	@GetMapping
	public String getGretting() {
		return "welcome to Spring security OAUTH2";
	}
	
	@GetMapping("/user")
	public String getUser() {
		return "welcome to User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "welcome to Admin";
	}
}
