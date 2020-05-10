package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Filial;
import io.guppy.ithappens.implementacao.repository.FilialRepository;

@Service
public class FilialService {

	@Autowired
	private FilialRepository filialRepository;

	public List<Filial> getAll() {
		return filialRepository.findAll();
	}
	
	public Filial findById(Long id) {
		if(id != null) {
			return filialRepository.findById(id).get();			
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filial não encontrada ou não existe");
	}

	public Filial save(Filial filial) {
		if (filial != null) {
			if (filial.getCodigoFilial() == null) {
				return filialRepository.save(filial);
			} else {
				Filial f = filial;
				f.setCodigoFilial(filial.getCodigoFilial());
				return filialRepository.save(f);
			}
		}

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
	}

	public void delete(Long id) {
		filialRepository.deleteById(id);
	}


}
