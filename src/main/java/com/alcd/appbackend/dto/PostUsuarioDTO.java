package com.alcd.appbackend.dto;

import java.io.Serializable;

import com.alcd.appbackend.domain.enums.Perfil;

public class PostUsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private Perfil perfil;
	
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfis(Perfil perfil) {
		this.perfil = perfil;
	}
	
}
