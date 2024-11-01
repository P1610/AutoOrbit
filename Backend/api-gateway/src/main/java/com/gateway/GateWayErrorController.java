package com.gateway;

import org.springframework.boot.web.servlet.error.ErrorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateWayErrorController implements ErrorController{

	@GetMapping("/error")
	public String handleError() {
		return "error page not found, Please try again later.";
	}
}
