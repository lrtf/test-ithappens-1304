package io.guppy.ithappens.implementacao.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.guppy.ithappens.implementacao.dto.PagamentoAVistaForm;
import io.guppy.ithappens.implementacao.dto.PagamentoBoletoForm;
import io.guppy.ithappens.implementacao.dto.PagamentoCartaoForm;
import io.guppy.ithappens.implementacao.dto.PagamentoDto;
import io.guppy.ithappens.implementacao.model.Pagamento;
import io.guppy.ithappens.implementacao.service.FormaPagamentoService;
import io.guppy.ithappens.implementacao.service.PagamentoService;
import io.guppy.ithappens.implementacao.service.PedidoEstoqueService;

@RestController
@RequestMapping("/rest/pagamentos")
public class PagamentoController {
	
	@Autowired
	private PedidoEstoqueService pedidoEstoqueService;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired 
	private FormaPagamentoService formaPagamentoService;
	
	
	@PostMapping("/boleto")
	public ResponseEntity<?> pagamentoBoleto(@RequestBody PagamentoBoletoForm form, UriComponentsBuilder uriBuilder){
		Pagamento p = form.converte(pedidoEstoqueService, formaPagamentoService);
		pagamentoService.boleto(p);
		URI uri =  uriBuilder.path("/rest/pagamentos/{id}").buildAndExpand(p.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new PagamentoDto(p));
	}
	
	@PostMapping("/Avista")
	public ResponseEntity<?> pagamentoAVista(@RequestBody PagamentoAVistaForm form, UriComponentsBuilder uriBuilder){
		Pagamento p = form.converte(pedidoEstoqueService, formaPagamentoService);
		pagamentoService.aVista(p);
		URI uri =  uriBuilder.path("/rest/pagamentos/{id}").buildAndExpand(p.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new PagamentoDto(p));
	}
	
	@PostMapping("/cartao")
	public ResponseEntity<?> pagamentoCartao(@RequestBody PagamentoCartaoForm form, UriComponentsBuilder uriBuilder){
		Pagamento p = form.converte(pedidoEstoqueService, formaPagamentoService);
		pagamentoService.cartao(p);
		URI uri =  uriBuilder.path("/rest/pagamentos/{id}").buildAndExpand(p.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new PagamentoDto(p));
	}

}
