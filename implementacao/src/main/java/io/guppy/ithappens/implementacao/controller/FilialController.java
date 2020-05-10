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

import io.guppy.ithappens.implementacao.model.Filial;
import io.guppy.ithappens.implementacao.service.FilialService;

@RestController
@RequestMapping("/rest/filiais")
public class FilialController {
	
	@Autowired
	FilialService filialService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(filialService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Filial>(filialService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Filial filial, UriComponentsBuilder uriBuilder){
		Filial f = filialService.save(filial);
		URI uri = uriBuilder.path("/rest/filiais/{id}").buildAndExpand(f.getCodigoFilial()).toUri();
		return ResponseEntity.created(uri).body(f);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Filial filial){
		return new ResponseEntity<Filial>(filialService.save(filial), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		filialService.delete(id);
		return ResponseEntity.ok().build();
	}

}
