package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Estoque;
import io.guppy.ithappens.implementacao.repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	EstoqueRepository estoqueRepository;

	public List<Estoque> getAll() {
		return estoqueRepository.findAll();
	}

	public Estoque findById(Long id) {
		if (id != null) {
			return estoqueRepository.findById(id).get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estoque não encontrado ou não existe.");
	}

	public Estoque save(Estoque estoque) {
		if (estoque != null) {
			if (estoque.getCodigoEstoque() == null) {
				return estoqueRepository.save(estoque);
			} else {
				Estoque e = estoque;
				e.setCodigoEstoque(estoque.getCodigoEstoque());
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
	}

}
