package io.guppy.ithappens.implementacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
