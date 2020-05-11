package io.guppy.ithappens.implementacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	Optional<Estoque> findByProdutoCodigoProduto(Long codigoProduto);
	

}
