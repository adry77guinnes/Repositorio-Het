package com.ejemplo.cliente_empleados.repository;

import com.ejemplo.cliente_empleados.model.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Repository
public class EmpleadoRepositoryImpl implements EmpleadoRepository {

    private final WebClient webClient;

    public EmpleadoRepositoryImpl() {

        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(30));

        this.webClient = WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Override
    public List<Empleado> obtenerEmpleados() {

        Empleado[] response = webClient.get()
                .uri("http://localhost:8082/empleados/listar")
                .retrieve()
                .bodyToMono(Empleado[].class)
                .block();

        return Arrays.asList(response);
    }

    @Override
    public void obtenerEmpleadosAsync() {

        webClient.get()
                .uri("http://localhost:8082/empleados/listar")
                .retrieve()
                .bodyToMono(Empleado[].class)
                .timeout(Duration.ofSeconds(30))
                .subscribe(response -> {

                    System.out.println("RESPUESTA ASÍNCRONA:");

                    for (Empleado e : response) {
                        System.out.println(e);
                    }
                });
    }
}