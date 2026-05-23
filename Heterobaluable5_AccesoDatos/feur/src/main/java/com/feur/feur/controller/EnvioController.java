package com.feur.feur.controller;

import com.feur.feur.dto.ActualizacionDestinoDto;
import com.feur.feur.dto.CodigoEnvioDto;
import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;
import com.feur.feur.service.EnvioService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<EnvioDto> listar(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaDesde,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaHasta,
            @RequestParam(required = false) String dni,
            @RequestParam(required = false) String nombreSolicitante,
            @RequestParam(required = false) String telefonoOrigen,
            @RequestParam(required = false) String telefonoDestino
    ) {
        return envioService.listar(
                fechaDesde,
                fechaHasta,
                dni,
                nombreSolicitante,
                telefonoOrigen,
                telefonoDestino
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CodigoEnvioDto crear(@Valid @RequestBody PeticionCreacionEnvio data) {
        return envioService.crear(data);
    }

    @PutMapping("/{codigo}/destino")
    public ResponseEntity<EnvioDto> actualizarDestino(
            @PathVariable String codigo,
            @Valid @RequestBody ActualizacionDestinoDto destino
    ) {
        EnvioDto actualizado = envioService.actualizarDestino(codigo, destino);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(@PathVariable String codigo) {
        boolean eliminado = envioService.eliminar(codigo);

        if (!eliminado) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
