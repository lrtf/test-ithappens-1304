package io.guppy.ithappens.implementacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.guppy.ithappens.implementacao.model.Usuario;
import io.guppy.ithappens.implementacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAll() {
		return usuarioRepository.findAll();
	}

	public Usuario finById(Long id) {
		if (id != null) {
			return usuarioRepository.findById(id).get();
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado ou não existe");
	}

	public Usuario save(Usuario usuario) {
		if (usuario != null) {
			if (usuario.getCodigoUsuario() == null) {
				return usuarioRepository.save(usuario);
			} else {
				Usuario u = usuario;
				u.setCodigoUsuario(usuario.getCodigoUsuario());
				return usuarioRepository.save(u);
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados invalidos");
	}

	public Usuario findById(Long codigoUsuario) {
		return usuarioRepository.findById(codigoUsuario)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado"));
	}

	public void delete(Long id) {
		if (id != null) {
			usuarioRepository.deleteById(id);
		}
	}

}
