package com.feur.mensajeria.controller;

import com.feur.mensajeria.model.*;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/envios")
public class EnvioController {

    private List<Envio> envios = new ArrayList<>();

    public EnvioController() {

        Envio e1 = new Envio();
        e1.setCodigoEnvio("FEUR-001");

        Peticion p1 = new Peticion();
        p1.setCodigoCliente("CL-123");
        p1.setFechaCreacion(LocalDate.now());

        Solicitante s1 = new Solicitante();
        s1.setDni("12345678A");
        s1.setNombre("Juan Pérez");
        s1.setTelefono("600123123");

        Direccion o1 = new Direccion();
        o1.setDireccion("Calle Mayor 1");
        o1.setCiudad("Valladolid");
        o1.setPersonaContacto("María");
        o1.setTelefono("600111111");

        Direccion d1 = new Direccion();
        d1.setDireccion("Gran Vía 10");
        d1.setCiudad("Madrid");
        d1.setPersonaContacto("Pedro");
        d1.setTelefono("600222222");

        Mercancia m1 = new Mercancia();
        m1.setTipo("Electrónica");
        m1.setPeso(5);
        m1.setNumeroBultos(1);
        m1.setAnchura(30);
        m1.setLongitud(40);
        m1.setAltura(20);

        p1.setSolicitante(s1);
        p1.setOrigen(o1);
        p1.setDestino(d1);
        p1.setMercancia(m1);

        e1.setPeticion(p1);

        envios.add(e1);
    }

    @GetMapping
    public List<Envio> listarEnvios() {
        return envios;
    }

    @PostMapping
    public String crearEnvio(@RequestBody Peticion peticion) {
        String codigo = "FEUR-" + (envios.size() + 1);

        Envio envio = new Envio();
        envio.setCodigoEnvio(codigo);
        envio.setPeticion(peticion);

        envios.add(envio);
        return codigo;
    }

    @PutMapping("/{codigo}")
    public String cambiarDestino(@PathVariable String codigo, @RequestBody Direccion nuevoDestino) {
        return "OK";
    }

    @DeleteMapping("/{codigo}")
    public String borrarEnvio(@PathVariable String codigo) {
        return "OK";
    }
}