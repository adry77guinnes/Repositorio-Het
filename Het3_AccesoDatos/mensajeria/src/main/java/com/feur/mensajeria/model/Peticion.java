package com.feur.mensajeria.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Peticion {
    private Solicitante solicitante;
    private Direccion origen;
    private Direccion destino;
    private Mercancia mercancia;
    private LocalDate fechaCreacion;
    private String codigoCliente;
}