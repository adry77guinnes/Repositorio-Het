package com.feur.feur.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EnvioDto {

    private String solicitanteDni;
    private String solicitanteNombre;
    private String solicitanteTelefono;

    private String origenDireccion;
    private String origenCiudad;
    private String origenPersonaContacto;
    private String origenTelefono;

    private String destinoDireccion;
    private String destinoCiudad;
    private String destinoPersonaContacto;
    private String destinoTelefono;

    private String tipo;
    private double peso;
    private int numeroBultos;
    private double anchura;
    private double longitud;
    private double altura;

    private LocalDate fechaCreacion;
}