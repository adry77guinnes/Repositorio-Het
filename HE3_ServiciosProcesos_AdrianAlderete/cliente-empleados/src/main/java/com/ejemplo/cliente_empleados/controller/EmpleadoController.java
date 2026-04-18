package com.ejemplo.cliente_empleados.controller;

import com.ejemplo.cliente_empleados.model.Empleado;
import com.ejemplo.cliente_empleados.service.EmpleadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/het3")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping("/sync/empleados")
    public List<Empleado> obtenerEmpleados() {
        return empleadoService.obtenerEmpleados();
    }

    @GetMapping("/async/empleados")
    public String obtenerEmpleadosAsync() {

        empleadoService.obtenerEmpleadosAsync();

        return "OK";
    }
}