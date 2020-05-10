package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Cliente;
import io.guppy.ithappens.implementacao.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Long id) {
		if(id != null) {
			return clienteRepository.findById(id).get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado.");
	}

	public Cliente save(Cliente cliente) {
		if (cliente != null) {
			if (cliente.getCodigoCliente() == null) {
				return clienteRepository.save(cliente);
			} else {
				Cliente c = cliente;
				c.setCodigoCliente(cliente.getCodigoCliente());
				return clienteRepository.save(c);
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
	}

	public void delete(Long codigoUsuario) {
		clienteRepository.deleteById(codigoUsuario);
	}

}
