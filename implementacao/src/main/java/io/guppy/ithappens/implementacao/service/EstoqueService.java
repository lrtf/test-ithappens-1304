package io.guppy.ithappens.implementacao.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guppy.ithappens.implementacao.model.Estoque;
import io.guppy.ithappens.implementacao.repository.EstoqueRepository;

@Service
public class EstoqueService {
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	public List<Estoque> getAll() {
		return estoqueRepository.findAll();
	}
	
	public Estoque save(Estoque estoque) {
		if(estoque != null) {
			return estoqueRepository.save(estoque);			
		}
		throw new NoSuchElementException();
	}

}
