package com.ejemplo.cliente_empleados.service;

import com.ejemplo.cliente_empleados.model.Empleado;
import java.util.List;

public interface EmpleadoService {

    List<Empleado> obtenerEmpleados();
    void obtenerEmpleadosAsync();
}