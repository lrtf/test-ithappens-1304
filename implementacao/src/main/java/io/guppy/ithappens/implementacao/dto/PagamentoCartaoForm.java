package io.guppy.ithappens.implementacao.dto;

import io.guppy.ithappens.implementacao.model.Pagamento;
import io.guppy.ithappens.implementacao.service.FormaPagamentoService;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;

public class PagamentoCartaoForm {

	private Long codigoPedido;
	private int parcelas;

	public Pagamento converte(PedidoEstoqueService pedidoEstoqueService, FormaPagamentoService formaPagamentoService) {
		Pagamento pagamento = new Pagamento();
		pagamento.setPedidoEstoque(pedidoEstoqueService.findById(codigoPedido));
		pagamento.setStatus("PARCELADO");
		pagamento.setFormaPagamento(formaPagamentoService.tipoPagamento(3L));
		pagamento.setParcelas(parcelas);
		return pagamento;
	}

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

}
