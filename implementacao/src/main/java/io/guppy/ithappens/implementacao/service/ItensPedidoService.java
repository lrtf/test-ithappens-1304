package io.guppy.ithappens.implementacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.guppy.ithappens.implementacao.repository.ItensPedidoRepository;

/**
 * 
 * @author luis ricardo
 *
 */

@Service
public class ItensPedidoService {
	
	@Autowired
	private ItensPedidoRepository itensPedidoRepository;

}
