package io.guppy.ithappens.implementacao.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.ItensPedido;
import io.guppy.ithappens.implementacao.model.StatusItensPedido;
import io.guppy.ithappens.implementacao.repository.ItensPedidoRepository;

/**
 * 
 * @author luis ricardo
 *
 */

@Service
public class ItensPedidoService {

	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

	public List<ItensPedido> getAll() {
		return itensPedidoRepository.findAll();
	}

	public ItensPedido removeItem(Long idPedido, Long idProduto) {
		if (idPedido != null && idProduto != null) {
			ItensPedido ip = itensPedidoRepository.findByPedidoEstoqueCodigoPedidoAndProdutoCodigoProduto(idPedido, idProduto).get();
			if (ip.getStatus().equals(StatusItensPedido.ATIVO))
				ip.setStatus(StatusItensPedido.CANCELADO);
			return itensPedidoRepository.save(ip);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}

	public ItensPedido findById(Long id) {
		if (id != null)
			return itensPedidoRepository.findById(id).get();
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}
	
	public ItensPedido adicionaItem(ItensPedido itens) {
		if (itens != null && itens.getQuantidade() > 0) {
			getAllItens(itens.getPedidoEstoque().getCodigoPedido()).stream()
					.map(ip -> {
						if (ip.getProduto().getCodigoProduto() == itens.getProduto().getCodigoProduto()
								&& (ip.getStatus().equals(StatusItensPedido.ATIVO)
										|| ip.getStatus().equals(StatusItensPedido.PROCESSADO))) {
							throw new RuntimeException("O item já está cadastrado no pedido!");
						}
						return ip;
					}).collect(Collectors.toList());
			
			itens.setValorUnitario(itens.getProduto().getValorUnitario());
			itens.setTotal(itens.getProduto().getValorUnitario().multiply(new BigDecimal(itens.getQuantidade())));

			return itensPedidoRepository.save(itens);
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");

	}

	public List<ItensPedido> getAllItens(Long codigoPedidoEstoque) {
		return itensPedidoRepository.findAllByPedidoEstoqueCodigoPedido(codigoPedidoEstoque).stream()
				.filter(item -> item.getStatus().equals(StatusItensPedido.ATIVO) || item.getStatus().equals(StatusItensPedido.PROCESSADO))
				.collect(Collectors.toList());
	}

}
