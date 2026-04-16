package com.feur.feur.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Getter
@Setter
public class PeticionCreacionEnvio {

    // SOLICITANTE

    @NotNull(message = "El DNI del solicitante es obligatorio")
    @Size(max = 9)
    private String solicitanteDni;

    @NotNull
    @Size(max = 50)
    private String solicitanteNombre;

    @NotNull
    @Size(max = 15)
    private String solicitanteTelefono;

    // ORIGEN

    @NotNull
    private String origenDireccion;

    @NotNull
    private String origenCiudad;

    private String origenPersonaContacto;

    private String origenTelefono;

    // DESTINO

    @NotNull
    private String destinoDireccion;

    @NotNull
    private String destinoCiudad;

    private String destinoPersonaContacto;

    private String destinoTelefono;

    // MERCANCIA

    @NotNull
    private String tipo;

    @NotNull
    private Double peso;

    @NotNull
    private Integer numeroBultos;

    private Double anchura;
    private Double longitud;
    private Double altura;
}