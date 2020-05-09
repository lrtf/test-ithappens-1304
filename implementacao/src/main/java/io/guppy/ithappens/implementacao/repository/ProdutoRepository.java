package io.guppy.ithappens.implementacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Optional<Produto> findById(Long id);
	Optional<Produto> findByDescricaoOrCodigoBarras(String descricao, String codigoBarras);

}
