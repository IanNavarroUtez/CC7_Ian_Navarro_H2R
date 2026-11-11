package com.example.h2r_Ian_Navarro_cc7.service;

import com.example.h2r_Ian_Navarro_cc7.dtos.CrearPedidoDTO;
import com.example.h2r_Ian_Navarro_cc7.errorhandler.CustomException;
import com.example.h2r_Ian_Navarro_cc7.model.Pedido;
import com.example.h2r_Ian_Navarro_cc7.model.PedidoEstado;
import com.example.h2r_Ian_Navarro_cc7.model.Producto;
import com.example.h2r_Ian_Navarro_cc7.repos.PedidoRepo;
import com.example.h2r_Ian_Navarro_cc7.repos.ProductoRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    private final PedidoRepo pedidoRepo;
    private final ProductoRepo productoRepo;
    public MainService(PedidoRepo pedidoRepo, ProductoRepo productoRepo){
        this.pedidoRepo = pedidoRepo;
        this.productoRepo = productoRepo;
    }

/*
Crear pedido — 30 puntos
Recibir el ID del producto, nombre del cliente y cantidad solicitada. == DTO
Validar que el producto exista. == ya
Validar que el producto esté activo. == ya
Validar que el nombre del cliente no esté vacío. == ya
Validar que la cantidad sea mayor a cero. == ya
Comprobar que exista suficiente stock. == ya
Obtener automáticamente el precio actual del producto. == ya
Calcular el total multiplicando el precio unitario por la cantidad. == ya
Crear el pedido con estado PENDIENTE. == ya
Descontar del stock la cantidad solicitada. == ya
Guardar los cambios en la base de datos.
 */
    @Transactional
    public Pedido crearPedido(CrearPedidoDTO dto){
        Producto producto = productoRepo.findById(dto.getProductoID()).orElseThrow(()->
                new CustomException("El producto no existe")
            );

        if (!producto.isActivo()){
            throw new CustomException("El producto no esta activo");
        }

        if (producto.getStock() < 1){
            throw new CustomException("No hay suficiente stock");
        }

        Pedido pedido = new Pedido();

        pedido.setPrecioUnitario(producto.getPrecio());
        pedido.setTotal(producto.getPrecio()*dto.getCantidadSolicitada());
        pedido.setEstado(PedidoEstado.PENDIENTE);

        producto.setStock(producto.getStock()-dto.getCantidadSolicitada());

        productoRepo.save(producto);
        pedidoRepo.save(pedido);

        return pedido;
    }
}
