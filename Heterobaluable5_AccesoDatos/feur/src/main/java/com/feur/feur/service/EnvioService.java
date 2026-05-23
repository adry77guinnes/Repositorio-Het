package com.feur.feur.service;

import com.feur.feur.dto.ActualizacionDestinoDto;
import com.feur.feur.dto.CodigoEnvioDto;
import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;

import java.time.LocalDate;
import java.util.List;

public interface EnvioService {

    CodigoEnvioDto crear(PeticionCreacionEnvio data);

    List<EnvioDto> listar(
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            String dni,
            String nombreSolicitante,
            String telefonoOrigen,
            String telefonoDestino
    );

    EnvioDto actualizarDestino(String codigo, ActualizacionDestinoDto destino);

    boolean eliminar(String codigo);
}
