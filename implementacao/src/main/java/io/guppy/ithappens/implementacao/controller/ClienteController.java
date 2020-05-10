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

import io.guppy.ithappens.implementacao.model.Cliente;
import io.guppy.ithappens.implementacao.service.ClienteService;

@RestController
@RequestMapping("/rest/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(clienteService.getAll());
	}
	
	//Implementar Usuario Dto
	@GetMapping("/{id}")
	public ResponseEntity<?> finById(@PathVariable("id") Long id) {
		return new ResponseEntity<Cliente>(clienteService.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cliente cliente, UriComponentsBuilder uriBuilder) {
		Cliente c = clienteService.save(cliente);
		URI uri = uriBuilder.path("/rest/clientes/{id}").buildAndExpand(c.getCodigoCliente()).toUri();
		return ResponseEntity.created(uri).body(c);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Cliente cliente) {
		return new ResponseEntity<Cliente>(clienteService.save(cliente), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		clienteService.delete(id);
		return ResponseEntity.ok().build();
	}

}
