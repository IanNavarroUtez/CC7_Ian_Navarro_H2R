package com.example.h2r_Ian_Navarro_cc7.controller;

import com.example.h2r_Ian_Navarro_cc7.dtos.CrearPedidoDTO;
import com.example.h2r_Ian_Navarro_cc7.model.Pedido;
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


}
