package io.guppy.ithappens.implementacao.dto;

import java.math.BigDecimal;

import io.guppy.ithappens.implementacao.model.StatusItensPedido;

public class ResponseItensPedidoDto {
	private StatusItensPedido status;
	private Long codigo;
	private String codigoBarra;
	private String descricao;
	private int quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal total;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public StatusItensPedido getStatus() {
		return status;
	}
	public void setStatus(StatusItensPedido status) {
		this.status = status;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	
	
	
	

}
