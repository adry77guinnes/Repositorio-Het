package com.feur.feur.repository;

import com.feur.feur.model.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {

    Optional<Envio> findByCodigo(String codigo);

    void deleteByCodigo(String codigo);

    @Query("""
            SELECT e FROM Envio e
            WHERE (:fechaDesde IS NULL OR e.fechaCreacion >= :fechaDesde)
              AND (:fechaHasta IS NULL OR e.fechaCreacion <= :fechaHasta)
              AND (:dni IS NULL OR e.solicitanteDni = :dni)
              AND (:nombreSolicitante IS NULL OR e.solicitanteNombre = :nombreSolicitante)
              AND (:telefonoOrigen IS NULL OR e.origenTelefono = :telefonoOrigen)
              AND (:telefonoDestino IS NULL OR e.destinoTelefono = :telefonoDestino)
            """)
    List<Envio> buscarConFiltros(
            @Param("fechaDesde") LocalDate fechaDesde,
            @Param("fechaHasta") LocalDate fechaHasta,
            @Param("dni") String dni,
            @Param("nombreSolicitante") String nombreSolicitante,
            @Param("telefonoOrigen") String telefonoOrigen,
            @Param("telefonoDestino") String telefonoDestino
    );
}
