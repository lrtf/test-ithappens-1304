package io.guppy.ithappens.implementacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping
	public ResponseEntity<?> adicionaProdutoNoEstoque(@RequestBody Estoque estoque) {
		return new ResponseEntity<Estoque>(estoqueService.save(estoque), HttpStatus.CREATED);
	}

}
