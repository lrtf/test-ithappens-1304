package io.guppy.ithappens.implementacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.ItensPedido;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {

}
