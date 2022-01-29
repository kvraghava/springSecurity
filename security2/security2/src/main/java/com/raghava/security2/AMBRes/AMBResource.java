package com.raghava.security2.AMBRes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/AMB")
public class AMBResource {
	@GetMapping
	public String getGretting() {
		return "welcome to Spring security2";
	}
}
