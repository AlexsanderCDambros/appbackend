package com.alcd.appbackend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class HealthResource {

	@GetMapping()
	public String health() {
		return "API está funcionando";
	}
}
