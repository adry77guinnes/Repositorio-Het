package com.feur.feur.service;

import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;

import java.util.List;

public interface EnvioService {

    EnvioDto crear(PeticionCreacionEnvio data);

    List<EnvioDto> listar();
}