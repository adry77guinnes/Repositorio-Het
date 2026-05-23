package com.feur.feur.service;

import com.feur.feur.dto.ActualizacionDestinoDto;
import com.feur.feur.dto.CodigoEnvioDto;
import com.feur.feur.dto.EnvioDto;
import com.feur.feur.dto.PeticionCreacionEnvio;
import com.feur.feur.model.Envio;
import com.feur.feur.repository.EnvioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnvioServiceImpl implements EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioServiceImpl(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    @Override
    public CodigoEnvioDto crear(PeticionCreacionEnvio data) {
        Envio envio = new Envio();

        envio.setCodigo(generarCodigo());

        envio.setSolicitanteDni(data.getSolicitanteDni());
        envio.setSolicitanteNombre(data.getSolicitanteNombre());
        envio.setSolicitanteTelefono(data.getSolicitanteTelefono());

        envio.setOrigenDireccion(data.getOrigenDireccion());
        envio.setOrigenCiudad(data.getOrigenCiudad());
        envio.setOrigenPersonaContacto(data.getOrigenPersonaContacto());
        envio.setOrigenTelefono(data.getOrigenTelefono());

        envio.setDestinoDireccion(data.getDestinoDireccion());
        envio.setDestinoCiudad(data.getDestinoCiudad());
        envio.setDestinoPersonaContacto(data.getDestinoPersonaContacto());
        envio.setDestinoTelefono(data.getDestinoTelefono());

        envio.setTipo(data.getTipo());
        envio.setPeso(data.getPeso() != null ? data.getPeso() : 0);
        envio.setNumeroBultos(data.getNumeroBultos() != null ? data.getNumeroBultos() : 0);
        envio.setAnchura(data.getAnchura() != null ? data.getAnchura() : 0);
        envio.setLongitud(data.getLongitud() != null ? data.getLongitud() : 0);
        envio.setAltura(data.getAltura() != null ? data.getAltura() : 0);

        envio.setFechaCreacion(LocalDate.now());

        Envio saved = envioRepository.save(envio);
        return new CodigoEnvioDto(saved.getCodigo());
    }

    @Override
    public List<EnvioDto> listar(
            LocalDate fechaDesde,
            LocalDate fechaHasta,
            String dni,
            String nombreSolicitante,
            String telefonoOrigen,
            String telefonoDestino
    ) {
        return envioRepository.buscarConFiltros(
                        fechaDesde,
                        fechaHasta,
                        dni,
                        nombreSolicitante,
                        telefonoOrigen,
                        telefonoDestino
                )
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public EnvioDto actualizarDestino(String codigo, ActualizacionDestinoDto destino) {
        Envio envio = envioRepository.findByCodigo(codigo).orElse(null);

        if (envio == null) {
            return null;
        }

        envio.setDestinoDireccion(destino.getDestinoDireccion());
        envio.setDestinoCiudad(destino.getDestinoCiudad());
        envio.setDestinoPersonaContacto(destino.getDestinoPersonaContacto());
        envio.setDestinoTelefono(destino.getDestinoTelefono());

        return convertToDto(envioRepository.save(envio));
    }

    @Override
    public boolean eliminar(String codigo) {
        Envio envio = envioRepository.findByCodigo(codigo).orElse(null);

        if (envio == null) {
            return false;
        }

        envioRepository.delete(envio);
        return true;
    }

    private String generarCodigo() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private EnvioDto convertToDto(Envio envio) {
        EnvioDto dto = new EnvioDto();

        dto.setCodigo(envio.getCodigo());
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
