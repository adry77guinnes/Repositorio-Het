package com.feur.mensajeria.model;

import lombok.Data;

@Data
public class Envio {
    private String codigoEnvio;
    private Peticion peticion;
}