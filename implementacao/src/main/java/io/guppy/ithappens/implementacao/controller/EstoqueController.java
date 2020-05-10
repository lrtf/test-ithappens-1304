package io.guppy.ithappens.implementacao.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.guppy.ithappens.implementacao.model.Estoque;
import io.guppy.ithappens.implementacao.service.EstoqueService;

/**
 * 
 * @author luis ricardo
 *
 */

@RestController
@RequestMapping(path = "/rest/estoques")
public class EstoqueController {
	
	@Autowired
	EstoqueService estoqueService;
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(estoqueService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Estoque>(estoqueService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> adicionaProdutoNoEstoque(@RequestBody Estoque estoque, UriComponentsBuilder uriBuilder) {
		Estoque e = estoqueService.save(estoque);
		URI uri = uriBuilder.path("/rest/estoques/{id}").buildAndExpand(e.getCodigoEstoque()).toUri();
		return ResponseEntity.created(uri).body(e);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Estoque estoque){
		return new ResponseEntity<Estoque>(estoqueService.save(estoque), HttpStatus.OK);
	}

}
