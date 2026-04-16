package com.feur.feur.controller;

import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;
import com.feur.feur.service.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<EnvioDto> listar() {
        return envioService.listar();
    }
    @PostMapping
    public EnvioDto crear(@RequestBody PeticionCreacionEnvio data) {
        return envioService.crear(data);
    }
}