package io.guppy.ithappens.implementacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.PedidoEstoque;

public interface PedidoEstoqueRepository extends JpaRepository<PedidoEstoque, Long> {
	Optional<PedidoEstoque> findById(Long id);

}
