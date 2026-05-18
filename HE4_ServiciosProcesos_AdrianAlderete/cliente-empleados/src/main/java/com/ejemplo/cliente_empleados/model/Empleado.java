package com.ejemplo.cliente_empleados.model;

import lombok.Data;

@Data
public class Empleado {
    private String codigo;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String dni;
    private String puesto;
}
