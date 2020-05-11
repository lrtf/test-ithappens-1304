package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.FormaPagamento;
import io.guppy.ithappens.implementacao.repository.FormaPagamentoRepository;
import io.guppy.ithappens.implementacao.repository.ItensPedidoRepository;

@Service
public class FormaPagamentoService {
	
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;
	
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;
	
	public List<FormaPagamento> getAll(){
		return formaPagamentoRepository.findAll();
	}
	
	public FormaPagamento tipoPagamento(Long id) {
		if(id != null) {
			return  formaPagamentoRepository.findById(id).get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Forma de pagamento não econtrada!");
	}

}
