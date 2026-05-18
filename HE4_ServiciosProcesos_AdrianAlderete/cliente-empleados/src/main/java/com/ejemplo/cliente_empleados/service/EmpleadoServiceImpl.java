package com.ejemplo.cliente_empleados.service;

import com.ejemplo.cliente_empleados.model.Empleado;
import com.ejemplo.cliente_empleados.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return empleadoRepository.obtenerEmpleados();
    }

    @Override
    public void obtenerEmpleadosAsync() {
        empleadoRepository.obtenerEmpleadosAsync();
    }
}