package com.example.h2r_Ian_Navarro_cc7.repos;

import com.example.h2r_Ian_Navarro_cc7.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepo extends JpaRepository<Pedido, Long> {
}
