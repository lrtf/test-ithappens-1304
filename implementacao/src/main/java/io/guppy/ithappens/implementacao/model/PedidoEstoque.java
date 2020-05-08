package io.guppy.ithappens.implementacao.model;

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
public class PedidoEstoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoPedido;

	@Enumerated(EnumType.STRING)
	private TipoPedidoEstoque tipo;

	@ManyToOne
	@JoinColumn(name = "FK_FILIAL_CODIGO_FILIAL")
	private Filial filial;

	@ManyToOne
	@JoinColumn(name = "FK_USUARIO_CODIGO_USUARIO")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE_CODIGO_CLIENTE")
	private Cliente cliente;

	private String observacaoEntrega;

	public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public TipoPedidoEstoque getTipo() {
		return tipo;
	}

	public void setTipo(TipoPedidoEstoque tipo) {
		this.tipo = tipo;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacaoEntrega() {
		return observacaoEntrega;
	}

	public void setObservacaoEntrega(String observacaoEntrega) {
		this.observacaoEntrega = observacaoEntrega;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigoPedido ^ (codigoPedido >>> 32));
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
		PedidoEstoque other = (PedidoEstoque) obj;
		if (codigoPedido != other.codigoPedido)
			return false;
		return true;
	}

}
