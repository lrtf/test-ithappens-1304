package io.guppy.ithappens.implementacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
