package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Produto;
import io.guppy.ithappens.implementacao.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}

	public Produto save(Produto produto) {
		if (produto != null) {
			if (produto.getCodigoProduto() == null) {
				return produtoRepository.save(produto);
			} else {
				Produto p = produto;
				p.setCodigoProduto(produto.getCodigoProduto());
				return produtoRepository.save(p);
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}

	public Produto findById(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}
	
	public Produto buscaPorDescricaoOuCodigoBarras(String descricao, String codigoBarras) {
		return produtoRepository.findByDescricaoOrCodigoBarras(descricao, codigoBarras)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}

	public void delete(Long id) {
		if (id != null)
			produtoRepository.deleteById(id);
	}

}
