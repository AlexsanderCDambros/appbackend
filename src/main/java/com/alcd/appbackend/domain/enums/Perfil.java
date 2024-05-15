package com.alcd.appbackend.domain.enums;

public enum Perfil {
	
	ADMIN("admin"),
	USER("user");
	
	
	private String perfil;
	
	Perfil(String perfil) {
		this.perfil = perfil;
	}

	public String getPerfil() {
		return perfil;
	}
}
