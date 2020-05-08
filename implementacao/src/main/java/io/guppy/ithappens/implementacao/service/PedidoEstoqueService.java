package io.guppy.ithappens.implementacao.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guppy.ithappens.implementacao.model.PedidoEstoque;
import io.guppy.ithappens.implementacao.repository.PedidoEstoqueRepository;

@Service
public class PedidoEstoqueService {
	
	@Autowired
	private PedidoEstoqueRepository pedidoEstoqueRepository;
	
	public List<PedidoEstoque> getAll() {
		return pedidoEstoqueRepository.findAll();
	}
	
	public PedidoEstoque save(PedidoEstoque pedidoEstoque) {
		if(pedidoEstoque != null) {
			return pedidoEstoqueRepository.save(pedidoEstoque);
		}
		throw new NullPointerException();
	}
	
	
	public Optional<PedidoEstoque> findById(Long id) {
		if(id != null) {
			return pedidoEstoqueRepository.findById(id);
		}
		throw new NoSuchElementException();
	}
	

}
