package io.guppy.ithappens.implementacao.controller;

import java.net.URI;
import java.util.List;

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

import io.guppy.ithappens.implementacao.model.Produto;
import io.guppy.ithappens.implementacao.service.ProdutoService;

@RestController
@RequestMapping(path = "/rest/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public List<Produto> findAll() {
		return produtoService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Produto produto, UriComponentsBuilder uriBuilder){
		Produto p = produtoService.save(produto);
		URI uri = uriBuilder.path("/rest/produtos/{id}").buildAndExpand(p.getCodigoProduto()).toUri();
		return ResponseEntity.created(uri).body(p);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Produto produto){
		return new ResponseEntity<Produto>(produtoService.save(produto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		produtoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
