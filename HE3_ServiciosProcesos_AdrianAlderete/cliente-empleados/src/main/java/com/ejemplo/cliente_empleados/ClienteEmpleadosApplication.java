package com.ejemplo.cliente_empleados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ClienteEmpleadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteEmpleadosApplication.class, args);
	}

}
