package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guppy.ithappens.implementacao.model.Produto;
import io.guppy.ithappens.implementacao.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}
	

}
