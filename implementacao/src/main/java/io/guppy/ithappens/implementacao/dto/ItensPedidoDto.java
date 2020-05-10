package io.guppy.ithappens.implementacao.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import io.guppy.ithappens.implementacao.model.ItensPedido;
import io.guppy.ithappens.implementacao.model.StatusItensPedido;

public class ItensPedidoDto {

	private List<ResponseItensPedidoDto> itens = new ArrayList<>();
	private int totalDeItens;
	private BigDecimal valorTotal;

	public ItensPedidoDto(List<ItensPedido> itensPedido) {
		for (ItensPedido item : itensPedido) {
			ResponseItensPedidoDto responseDto = new ResponseItensPedidoDto();
			responseDto.setCodigo(item.getProduto().getCodigoProduto());
			responseDto.setStatus(item.getStatus());
			responseDto.setCodigoBarra(item.getProduto().getCodigoBarras());
			responseDto.setDescricao(item.getProduto().getDescricao());
			responseDto.setQuantidade(item.getQuantidade());
			responseDto.setValorUnitario(item.getProduto().getValorUnitario());
			responseDto.setTotal(item.getProduto().getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
			itens.add(responseDto);

			this.totalDeItens = itens.size();
			this.valorTotal = itens.stream().filter(status -> status.getStatus().equals(StatusItensPedido.ATIVO))
					.map(total -> total.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);

		}

	}

	public int getTotalDeItens() {
		return totalDeItens;
	}

	public void setTotalDeItens(int totalDeItens) {
		this.totalDeItens = totalDeItens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ResponseItensPedidoDto> getItens() {
		return itens;
	}

	public void setItens(List<ResponseItensPedidoDto> itens) {
		this.itens = itens;
	}

}
