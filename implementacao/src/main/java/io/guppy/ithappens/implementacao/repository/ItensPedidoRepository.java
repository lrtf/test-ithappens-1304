package io.guppy.ithappens.implementacao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.guppy.ithappens.implementacao.model.ItensPedido;

public interface ItensPedidoRepository extends JpaRepository<ItensPedido, Long> {
	
	Optional<ItensPedido> findByProdutoCodigoProduto(Long id);

	Optional<ItensPedido> findByPedidoEstoqueCodigoPedidoAndProdutoCodigoProduto(Long idPedido, Long idProduto);

	List<ItensPedido> findAllByPedidoEstoqueCodigoPedido(Long id);
}
