package io.guppy.ithappens.implementacao.dto;

import java.math.BigDecimal;

import io.guppy.ithappens.implementacao.model.Pagamento;
import io.guppy.ithappens.implementacao.service.FormaPagamentoService;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;

public class PagamentoAVistaForm {
	private Long codigoPedido;
	private BigDecimal dinheiro;
	
	public Pagamento converte(PedidoEstoqueService pedidoEstoqueService, FormaPagamentoService formaPagamentoService) {
		Pagamento pagamento = new Pagamento();
		pagamento.setPedidoEstoque(pedidoEstoqueService.findById(codigoPedido));
		pagamento.setStatus("A VISTA");
		pagamento.setValorPago(dinheiro);
		pagamento.setFormaPagamento(formaPagamentoService.tipoPagamento(1L));
		return pagamento;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public BigDecimal getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(BigDecimal dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	


}
