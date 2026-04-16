package com.feur.feur.service;

import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;
import com.feur.feur.model.Envio;
import com.feur.feur.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioServiceImpl(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public EnvioDto crear(PeticionCreacionEnvio data) {

        Envio envio = new Envio();

        // SOLICITANTE
        envio.setSolicitanteDni(data.getSolicitanteDni());
        envio.setSolicitanteNombre(data.getSolicitanteNombre());
        envio.setSolicitanteTelefono(data.getSolicitanteTelefono());

        // ORIGEN
        envio.setOrigenDireccion(data.getOrigenDireccion());
        envio.setOrigenCiudad(data.getOrigenCiudad());
        envio.setOrigenPersonaContacto(data.getOrigenPersonaContacto());
        envio.setOrigenTelefono(data.getOrigenTelefono());

        // DESTINO
        envio.setDestinoDireccion(data.getDestinoDireccion());
        envio.setDestinoCiudad(data.getDestinoCiudad());
        envio.setDestinoPersonaContacto(data.getDestinoPersonaContacto());
        envio.setDestinoTelefono(data.getDestinoTelefono());

        // MERCANCIA
        envio.setTipo(data.getTipo());
        envio.setPeso(data.getPeso());
        envio.setPeso(data.getPeso() != null ? data.getPeso() : 0);
        envio.setNumeroBultos(data.getNumeroBultos() != null ? data.getNumeroBultos() : 0);

        envio.setAnchura(data.getAnchura() != null ? data.getAnchura() : 0);
        envio.setLongitud(data.getLongitud() != null ? data.getLongitud() : 0);
        envio.setAltura(data.getAltura() != null ? data.getAltura() : 0);

        // FECHA
        envio.setFechaCreacion(LocalDate.now());

        Envio saved = envioRepository.save(envio);

        return convertToDto(saved);
    }

    @Override
    public List<EnvioDto> listar() {

        return envioRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private EnvioDto convertToDto(Envio envio) {

        EnvioDto dto = new EnvioDto();

        dto.setSolicitanteDni(envio.getSolicitanteDni());
        dto.setSolicitanteNombre(envio.getSolicitanteNombre());
        dto.setSolicitanteTelefono(envio.getSolicitanteTelefono());

        dto.setOrigenDireccion(envio.getOrigenDireccion());
        dto.setOrigenCiudad(envio.getOrigenCiudad());
        dto.setOrigenPersonaContacto(envio.getOrigenPersonaContacto());
        dto.setOrigenTelefono(envio.getOrigenTelefono());

        dto.setDestinoDireccion(envio.getDestinoDireccion());
        dto.setDestinoCiudad(envio.getDestinoCiudad());
        dto.setDestinoPersonaContacto(envio.getDestinoPersonaContacto());
        dto.setDestinoTelefono(envio.getDestinoTelefono());

        dto.setTipo(envio.getTipo());
        dto.setPeso(envio.getPeso());
        dto.setNumeroBultos(envio.getNumeroBultos());
        dto.setAnchura(envio.getAnchura());
        dto.setLongitud(envio.getLongitud());
        dto.setAltura(envio.getAltura());

        dto.setFechaCreacion(envio.getFechaCreacion());

        return dto;
    }
}