package com.alcd.appbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alcd.appbackend.domain.Usuario;
import com.alcd.appbackend.dto.PostUsuarioDTO;
import com.alcd.appbackend.repositories.UsuarioRepository;
import com.alcd.appbackend.services.exceptions.ObjectNotFoundException;
import com.alcd.appbackend.services.exceptions.UnickKeyException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public List<Usuario> findAll() {
		List<Usuario> list = repo.findAll();
		return list;
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(PostUsuarioDTO obj) {
		Usuario usuario = new Usuario(null, obj.getLogin(), pe.encode(obj.getPassword()), obj.getPerfil());
		
		try {
			return repo.save(usuario);
		}
		catch (Exception ex) {
			throw new UnickKeyException("O Usuário " + obj.getLogin() + " não está disponível");
		}
	}
	
	public Usuario update(Usuario obj) {
		findById(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
}
