package io.guppy.ithappens.implementacao.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.guppy.ithappens.implementacao.model.PedidoEstoque;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;

/**
 * 
 * @author luis ricardo
 *
 */

@RestController
@RequestMapping(path = "/rest/pedidos")
public class ItensPedidoController {
	
	@Autowired
	PedidoEstoqueService pedidoEstoqueService;
	
	@GetMapping
	public ResponseEntity<?> findAll(){
		return ResponseEntity.ok(pedidoEstoqueService.getAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id){
		return new ResponseEntity<Optional<PedidoEstoque>>(pedidoEstoqueService.findById(id), HttpStatus.OK);
	}
	
	/*TESTE PARA CRIAR UM NOVO PEDIDO NO ESTOQUE - NÃO É RESPONSABILIDADE DESSE CONTROLLER*/
	@PostMapping
	public ResponseEntity<?> criaPedidoDeEstoque(@RequestBody PedidoEstoque pedidoEstoque, UriComponentsBuilder uriBuilder) {
		PedidoEstoque pe = pedidoEstoqueService.save(pedidoEstoque);
		URI uri = uriBuilder.path("/rest/pedidos/{id}").buildAndExpand(pe.getCodigoPedido()).toUri();
		return ResponseEntity.created(uri).body(pe);
	}
	

}
