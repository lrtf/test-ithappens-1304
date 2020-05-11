package io.guppy.ithappens.implementacao.dto;

import java.math.BigDecimal;

import io.guppy.ithappens.implementacao.model.Pagamento;

public class PagamentoDto {
	private Long codigoPedido;
	private BigDecimal valor;
	private String tipoPagamento;
	
	public PagamentoDto(Pagamento pagamento) {
		this.codigoPedido = pagamento.getPedidoEstoque().getCodigoPedido();
		this.valor = pagamento.getTotal();
		this.tipoPagamento = pagamento.getFormaPagamento().getDescricao();
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	

}
