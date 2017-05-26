package com.rama41222.CourseAPIApp.app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class App {

	@RequestMapping("/")
	public String sayHello(){
		return "Courses REST API v1.0.0";
	}
}
