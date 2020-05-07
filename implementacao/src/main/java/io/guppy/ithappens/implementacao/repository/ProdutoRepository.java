package io.guppy.ithappens.implementacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
