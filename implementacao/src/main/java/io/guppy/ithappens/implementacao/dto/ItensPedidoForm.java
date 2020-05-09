package io.guppy.ithappens.implementacao.dto;

import io.guppy.ithappens.implementacao.model.ItensPedido;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;
import io.guppy.ithappens.implementacao.service.ProdutoService;

public class ItensPedidoForm {
	private Long codPedidoEstoque;
	private Long codProduto;
	private String codigoBarras;
	private String descricaoProduto;
	private int quantidade;
	
	public Long getCodPedidoEstoque() {
		return codPedidoEstoque;
	}
	public void setCodPedidoEstoque(Long codPedidoEstoque) {
		this.codPedidoEstoque = codPedidoEstoque;
	}
	public Long getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codBarras) {
		this.codigoBarras = codBarras;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public ItensPedido converte(ProdutoService produtoService, PedidoEstoqueService pedidoEstoqueService) {
		ItensPedido ip = new ItensPedido();
		if(codPedidoEstoque != null) {
			if(codProduto != null) {
				ip.setPedidoEstoque(pedidoEstoqueService.findById(codPedidoEstoque));
				ip.setProduto(produtoService.findById(codProduto));
				ip.setQuantidade(quantidade);
			}else {
				ip.setPedidoEstoque(pedidoEstoqueService.findById(codPedidoEstoque));
				ip.setProduto(produtoService.buscaPorDescricaoOuCodigoBarras(descricaoProduto, codigoBarras));
				ip.setQuantidade(quantidade);
			}
		}
		return ip;
	}

}
