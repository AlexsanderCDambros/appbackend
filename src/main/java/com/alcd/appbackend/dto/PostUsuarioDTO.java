package com.alcd.appbackend.dto;

import java.io.Serializable;
import java.util.List;

public class PostUsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private List<String> perfis;
	
	public PostUsuarioDTO() {
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

	public List<String> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<String> perfis) {
		this.perfis = perfis;
	}
	
}
