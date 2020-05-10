package io.guppy.ithappens.implementacao.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.guppy.ithappens.implementacao.model.Usuario;
import io.guppy.ithappens.implementacao.service.UsuarioService;

@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(usuarioService.getAll());
	}
	
	//Implementar Usuario Dto
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Usuario>(usuarioService.finById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario, UriComponentsBuilder uriBuilder){
		Usuario u = usuarioService.save(usuario);
		URI uri = uriBuilder.path("/rest/usuarios/{id}").buildAndExpand(u.getCodigoUsuario()).toUri();
		return ResponseEntity.created(uri).body(u);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Usuario usuario){
		return new ResponseEntity<Usuario>(usuarioService.save(usuario), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		usuarioService.delete(id);
		return ResponseEntity.ok().build();
	}

}
