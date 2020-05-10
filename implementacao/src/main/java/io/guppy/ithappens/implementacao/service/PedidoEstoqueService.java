package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
		if (pedidoEstoque != null) {
			if (pedidoEstoque.getCodigoPedido() == null) {
				return pedidoEstoqueRepository.save(pedidoEstoque);
			} else {
				PedidoEstoque pe = pedidoEstoque;
				pe.setCodigoPedido(pedidoEstoque.getCodigoPedido());
				return pedidoEstoqueRepository.save(pe);
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}

	public PedidoEstoque findById(Long id) {
		return pedidoEstoqueRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido de estoque não encontrado"));
	}

	public void delete(Long id) {
		if (id != null)
			pedidoEstoqueRepository.deleteById(id);
	}

}
