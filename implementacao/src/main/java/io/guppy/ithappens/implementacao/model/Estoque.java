package io.guppy.ithappens.implementacao.model;

import javax.persistence.Entity;
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
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoEstoque;
	@ManyToOne
	@JoinColumn(name = "FK_PRODUTO_CODIGO_PRODUTO")
	private Produto produto;
	private long quantidade;
	@ManyToOne
	@JoinColumn(name = "FK_FILIAL_CODIGO_FILIAL")
	private Filial filial;

	public Long getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Long codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}
	
	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoEstoque ^ (codigoEstoque >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		if (codigoEstoque != other.codigoEstoque)
			return false;
		return true;
	}

}
