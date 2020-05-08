package io.guppy.ithappens.implementacao.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
 * @author luis ricardo
 *
 */

@Entity
public class ItensPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long item;
	
	@ManyToOne
	@JoinColumn(name = "FK_PRODUTO_CODIGO_PRODUTO")
	private Produto produto;
	
	@Enumerated(EnumType.STRING)
	private StatusItensPedido status;
	
	private int quantidade;
	
	private BigDecimal valorUnitario;
	
	private BigDecimal valorTotal;

	public Long getItem() {
		return item;
	}

	public void setItem(Long item) {
		this.item = item;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public StatusItensPedido getStatusItensPedido() {
		return status;
	}

	public void setStatusItensPedido(StatusItensPedido status) {
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
