package com.example.h2r_Ian_Navarro_cc7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCliente;
    private Integer cantidad;
    private Double precioUnitario;
    private Double total;
    @Enumerated(EnumType.STRING)
    private PedidoEstado estado;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
}

