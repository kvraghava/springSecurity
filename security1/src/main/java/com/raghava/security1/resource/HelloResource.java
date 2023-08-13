package com.raghava.security1.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {
	
	@GetMapping
	public String getGretting() {
		return "welcome to Spring security";
	}
}
