package tech.petko4.hrportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String homepage() {
		return "public/homepage";
	}
	
	@GetMapping("/jobs")
	public String jobs() {
		return "public/jobs";
	}
	
	@GetMapping("/job/{id}")
	public String jobDetail() {
	    return "public/job.html";
	}
}
