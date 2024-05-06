package com.alcd.appbackend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@GetMapping()
	public String health() {
		return "Usuarios está funcionando";
	}
}
