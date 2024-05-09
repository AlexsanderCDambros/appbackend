package com.alcd.appbackend.dto;

import java.io.Serializable;
import java.util.Set;

import com.alcd.appbackend.domain.Usuario;
import com.alcd.appbackend.domain.enums.Perfil;

public class GetUsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String login;
	private Set<Perfil> perfis;
	
	public GetUsuarioDTO() {
	}
	
	public GetUsuarioDTO(Usuario usuario) {
		login = usuario.getLogin();
		perfis = usuario.getPerfis();
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public Set<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(Set<Perfil> perfis) {
		this.perfis = perfis;
	}

	
}
