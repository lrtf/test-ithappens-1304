package io.guppy.ithappens.implementacao.dto;

import io.guppy.ithappens.implementacao.model.Pagamento;
import io.guppy.ithappens.implementacao.service.FormaPagamentoService;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;

public class PagamentoBoletoForm {
	private Long codigoPedido;
	
	public Pagamento converte(PedidoEstoqueService pedidoEstoqueService, FormaPagamentoService formaPagamentoService) {
		Pagamento pagamento = new Pagamento();
		pagamento.setStatus("PENDENTE");
		pagamento.setPedidoEstoque(pedidoEstoqueService.findById(codigoPedido));
		pagamento.setFormaPagamento(formaPagamentoService.tipoPagamento(2L));
		return pagamento;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	
	

}
