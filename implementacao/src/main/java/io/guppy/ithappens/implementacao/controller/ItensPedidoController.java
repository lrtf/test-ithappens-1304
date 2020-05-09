package io.guppy.ithappens.implementacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.guppy.ithappens.implementacao.dto.ItensPedidoDto;
import io.guppy.ithappens.implementacao.dto.ItensPedidoForm;
import io.guppy.ithappens.implementacao.model.ItensPedido;
import io.guppy.ithappens.implementacao.service.ItensPedidoService;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;
import io.guppy.ithappens.implementacao.service.ProdutoService;

/**
 * 
 * @author luis ricardo
 *
 */

@RestController
@RequestMapping(path = "/rest/itens")
public class ItensPedidoController {
	
	@Autowired
	ItensPedidoService itensPedidoService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	PedidoEstoqueService pedidoEstoqueService;
	
	@GetMapping
	ResponseEntity<?> getAll(){
		return ResponseEntity.ok(itensPedidoService.getAll());
	}

	
	@PostMapping
	ResponseEntity<?> adicionaItem(@RequestBody ItensPedidoForm form){
		ItensPedido ip = form.converte(produtoService, pedidoEstoqueService);
		itensPedidoService.adicionaItem(ip);
		List<ItensPedido> pedidos = itensPedidoService.getAllItens(ip.getPedidoEstoque().getCodigoPedido());
			
		return ResponseEntity.ok(new ItensPedidoDto(pedidos));
	}
	
	@PutMapping("/remove/{idPedido}/{idProduto}")
	ResponseEntity<?> removeItem(@PathVariable("idPedido") Long idPedido, @PathVariable("idProduto") Long idProduto){
		itensPedidoService.removeItem(idPedido, idProduto);
		return ResponseEntity.ok("Produto removido");
	}
	

}
