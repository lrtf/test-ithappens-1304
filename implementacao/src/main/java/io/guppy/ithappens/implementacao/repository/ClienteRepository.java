package io.guppy.ithappens.implementacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
