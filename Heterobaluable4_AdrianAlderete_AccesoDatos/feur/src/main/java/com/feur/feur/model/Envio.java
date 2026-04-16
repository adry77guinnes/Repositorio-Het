package com.feur.feur.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "ENVIO")
@Getter
@Setter
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solicitante_dni", nullable = false)
    private String solicitanteDni;

    @Column(name = "solicitante_nombre", nullable = false)
    private String solicitanteNombre;

    @Column(name = "solicitante_telefono")
    private String solicitanteTelefono;

    @Column(name = "origen_direccion")
    private String origenDireccion;

    @Column(name = "origen_ciudad")
    private String origenCiudad;

    @Column(name = "origen_persona")
    private String origenPersonaContacto;

    @Column(name = "origen_telefono")
    private String origenTelefono;

    @Column(name = "destino_direccion")
    private String destinoDireccion;

    @Column(name = "destino_ciudad")
    private String destinoCiudad;

    @Column(name = "destino_persona")
    private String destinoPersonaContacto;

    @Column(name = "destino_telefono")
    private String destinoTelefono;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "peso")
    private Double peso;

    @Column(name = "numero_bultos")
    private Integer numeroBultos;

    @Column(name = "anchura")
    private Double anchura;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "altura")
    private Double altura;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;
}