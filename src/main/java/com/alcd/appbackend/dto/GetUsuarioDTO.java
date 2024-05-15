package com.alcd.appbackend.dto;

import java.io.Serializable;

import com.alcd.appbackend.domain.Usuario;
import com.alcd.appbackend.domain.enums.Perfil;

public class GetUsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private Perfil perfil;
	
	public GetUsuarioDTO() {
	}
	
	public GetUsuarioDTO(Usuario usuario) {
		login = usuario.getLogin();
		perfil = usuario.getPerfil();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public Perfil getPerfis() {
		return perfil;
	}

	public void setPerfis(Perfil perfis) {
		this.perfil = perfis;
	}

	
}
