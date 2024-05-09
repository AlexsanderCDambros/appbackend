package com.alcd.appbackend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.alcd.appbackend.domain.Usuario;
import com.alcd.appbackend.dto.GetUsuarioDTO;
import com.alcd.appbackend.dto.PostUsuarioDTO;
import com.alcd.appbackend.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping()
	public ResponseEntity<List<GetUsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<GetUsuarioDTO> listDto = list.stream().map(obj -> new GetUsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody PostUsuarioDTO obj) {		
		Usuario usuario = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	// TODO: Trocar de put para push, só é possível alterar a senha e as permissões dos usuários
//	@PutMapping("/{id}")
//	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id) {
//		obj.setId(id);
//		obj = service.update(obj);
//		return ResponseEntity.noContent().build();
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
}
