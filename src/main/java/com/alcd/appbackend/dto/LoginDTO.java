package com.alcd.appbackend.dto;

import java.io.Serializable;

public class LoginDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;

	public LoginDTO() {
		
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
