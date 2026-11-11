package com.example.h2r_Ian_Navarro_cc7.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrearPedidoDTO {
//Recibir el ID del producto, nombre del cliente y cantidad solicitada.
    private Long productoID;
    @NotBlank
    private String nombreCliente;
    @Positive
    private Integer cantidadSolicitada;
}
