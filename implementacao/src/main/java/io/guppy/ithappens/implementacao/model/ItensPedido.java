package io.guppy.ithappens.implementacao.model;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class ItensPedido {

	private long item;
	private Produto produto;
	@Enumerated(EnumType.STRING)
	private Status status;
	private int quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;

	public long getItem() {
		return item;
	}

	public void setItem(long item) {
		this.item = item;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

}
