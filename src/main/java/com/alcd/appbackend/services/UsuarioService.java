package com.alcd.appbackend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcd.appbackend.domain.Usuario;
import com.alcd.appbackend.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
}
