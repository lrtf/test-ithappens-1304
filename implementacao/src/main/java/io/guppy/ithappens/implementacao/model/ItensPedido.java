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
	private StatusItensPedido status = StatusItensPedido.ATIVO;

	private int quantidade;

	private BigDecimal valorUnitario;

	private BigDecimal total;
	
	@ManyToOne
	//@JoinColumn(name = "FK_PEDIDO_ESTOQUE_CODIGO_ESTOQUE")
	@JoinColumn(name = "FK_PEDIDO_ESTOQUE_CODIGO_PEDIDO")
	private PedidoEstoque pedidoEstoque;

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
	
	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public StatusItensPedido getStatus() {
		return status;
	}

	public void setStatus(StatusItensPedido status) {
		this.status = status;
	}

	public PedidoEstoque getPedidoEstoque() {
		return pedidoEstoque;
	}

	public void setPedidoEstoque(PedidoEstoque pedidoEstoque) {
		this.pedidoEstoque = pedidoEstoque;
	}
	
	

}
