package com.example.h2r_Ian_Navarro_cc7.repos;

import com.example.h2r_Ian_Navarro_cc7.model.Pedido;
import com.example.h2r_Ian_Navarro_cc7.model.PedidoEstado;
import com.example.h2r_Ian_Navarro_cc7.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Long> {
    List<Pedido> findByProductoIdAndEstado(Long id, PedidoEstado estado);
}
