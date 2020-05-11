package io.guppy.ithappens.implementacao.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Estoque;
import io.guppy.ithappens.implementacao.model.Pagamento;
import io.guppy.ithappens.implementacao.model.StatusItensPedido;
import io.guppy.ithappens.implementacao.repository.EstoqueRepository;
import io.guppy.ithappens.implementacao.repository.ItensPedidoRepository;
import io.guppy.ithappens.implementacao.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	public Pagamento boleto(Pagamento pagamento) {
		if (pagamento != null) {
			pagamento.setTotal(valorTotal(pagamento.getPedidoEstoque().getCodigoPedido()));
			pagamentoRepository.save(pagamento);
			atualizaQuantidadeNoEstoque(pagamento.getPedidoEstoque().getCodigoPedido());
			atualizaStatusItensPagamento(pagamento.getPedidoEstoque().getCodigoPedido());
			return pagamento;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro ao gerar boleto");
	}

	public Pagamento aVista(Pagamento pagamento) {
		BigDecimal total = valorTotal(pagamento.getPedidoEstoque().getCodigoPedido());
		if (pagamento.getValorPago().compareTo(total) == -1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor informado é menor do que o valor total");
		} else if (pagamento.getValorPago().compareTo(total) == 1) {
			pagamento.setTotal(total);
			pagamento.setTroco(pagamento.getValorPago().subtract(total));
			pagamentoRepository.save(pagamento);
			atualizaStatusItensPagamento(pagamento.getPedidoEstoque().getCodigoPedido());
			atualizaQuantidadeNoEstoque(pagamento.getPedidoEstoque().getCodigoPedido());
			return pagamento;
		} else {
			pagamento.setTotal(total);
			pagamentoRepository.save(pagamento);
			atualizaStatusItensPagamento(pagamento.getPedidoEstoque().getCodigoPedido());
			atualizaQuantidadeNoEstoque(pagamento.getPedidoEstoque().getCodigoPedido());
			return pagamento;
		}
	}

	public Pagamento cartao(Pagamento pagamento) {
		if (pagamento != null && pagamento.getParcelas() >= 1) {
			pagamento.setTotal(valorTotal(pagamento.getPedidoEstoque().getCodigoPedido()));
			pagamento.setValorParcela(valorTotal(pagamento.getPedidoEstoque().getCodigoPedido())
					.divide(new BigDecimal(pagamento.getParcelas())));
			pagamentoRepository.save(pagamento);
			atualizaStatusItensPagamento(pagamento.getPedidoEstoque().getCodigoPedido());
			atualizaQuantidadeNoEstoque(pagamento.getPedidoEstoque().getCodigoPedido());
			return pagamento;
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ocorreu um erro, dados do cartão inválidos.");
	}

	private BigDecimal valorTotal(Long codigoPedido) {
		return itensPedidoRepository.findAllByPedidoEstoqueCodigoPedido(codigoPedido).stream()
				.filter(tipo -> tipo.getStatus().equals(StatusItensPedido.ATIVO)).map(total -> total.getTotal())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private void atualizaStatusItensPagamento(Long codigoPedido) {
		itensPedidoRepository.findAllByPedidoEstoqueCodigoPedido(codigoPedido).stream()
				.filter(status -> status.getStatus().equals(StatusItensPedido.ATIVO)).forEach(item -> {
					item.setStatus(StatusItensPedido.PROCESSADO);
					itensPedidoRepository.save(item);
				});
	}
	
	private void atualizaQuantidadeNoEstoque(Long codigoPedido) {
		itensPedidoRepository.findAllByPedidoEstoqueCodigoPedido(codigoPedido).stream()
		.filter(status -> status.getStatus().equals(StatusItensPedido.ATIVO) || status.getStatus().equals(StatusItensPedido.PROCESSADO))
		.forEach(estoque -> {
			Estoque e = estoqueRepository.findByProdutoCodigoProduto(estoque.getProduto().getCodigoProduto()).get();
			e.setQuantidade((e.getQuantidade() - estoque.getQuantidade()));
			estoqueRepository.save(e);

		});
	}

}
