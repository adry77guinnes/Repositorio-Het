package com.feur.mensajeria.model;

import lombok.Data;

@Data
public class Mercancia {
    private String tipo;
    private double peso;
    private int numeroBultos;
    private double anchura;
    private double longitud;
    private double altura;
}