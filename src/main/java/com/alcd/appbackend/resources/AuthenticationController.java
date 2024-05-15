package com.alcd.appbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alcd.appbackend.dto.LoginDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("login")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticatorManager;
	
	@PostMapping()
	public ResponseEntity<?> login(@RequestBody @Valid LoginDTO data) {
		var username = new UsernamePasswordAuthenticationToken(data.getLogin(), data.getPassword());
		var auth = this.authenticatorManager.authenticate(username);
		
		return ResponseEntity.ok().build();
	}
}
