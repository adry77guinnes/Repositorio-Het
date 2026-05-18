package com.ejemplo.cliente_empleados.repository;

import com.ejemplo.cliente_empleados.model.Empleado;
import java.util.List;

public interface EmpleadoRepository {

    List<Empleado> obtenerEmpleados();
    void obtenerEmpleadosAsync();
}
