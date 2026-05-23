package com.feur.feur.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActualizacionDestinoDto {

    @NotNull
    private String destinoDireccion;

    @NotNull
    private String destinoCiudad;

    private String destinoPersonaContacto;

    private String destinoTelefono;
}
