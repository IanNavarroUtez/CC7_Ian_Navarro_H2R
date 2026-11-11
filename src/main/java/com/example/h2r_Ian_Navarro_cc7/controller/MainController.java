package com.example.h2r_Ian_Navarro_cc7.controller;

import com.example.h2r_Ian_Navarro_cc7.dtos.CrearPedidoDTO;
import com.example.h2r_Ian_Navarro_cc7.model.Pedido;
import com.example.h2r_Ian_Navarro_cc7.model.Producto;
import com.example.h2r_Ian_Navarro_cc7.service.MainService;
import com.sun.tools.javac.Main;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controlador")
@CrossOrigin("*")
public class MainController {
    private final MainService servicio;
    public MainController(MainService servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/crearPedido")
    public ResponseEntity<Pedido> crearPedido(@RequestBody @Valid CrearPedidoDTO dto){
        return ResponseEntity.ok(servicio.crearPedido(dto));
    }

    @PatchMapping("/cancelarPedido/{id}")
    public ResponseEntity<Pedido> cancelarPedido(@PathVariable Long id){
        return ResponseEntity.ok(servicio.cancelarPedido(id));
    }

    @PatchMapping("/procesarPedido/{id}")
    public ResponseEntity<Pedido> procesarPedido(@PathVariable Long id){
        return  ResponseEntity.ok(servicio.procesarPedido(id));
    }

    @PatchMapping("/desactivarProducto/{id}")
    public ResponseEntity<Producto> desactivarProducto(@PathVariable Long id){
        return ResponseEntity.ok(servicio.desactivarProducto(id));
    }

    @PatchMapping("/cancelarTodosDeProducto/{id}")
    public ResponseEntity<Integer> cancelarTodsDeProducto(@PathVariable Long id){
        return ResponseEntity.ok(servicio.cancelarTodosPedidosDeProducto(id));
    }


}
