package com.example.heterovaluable2_accesodatos.controller;

import com.example.heterovaluable2_accesodatos.config.PropertiesClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {
    private final PropertiesClass propertiesClass;
    public MensajeController(PropertiesClass propertiesClass) {
        this.propertiesClass = propertiesClass;
    }
    @GetMapping
    public String mensaje() {
        return propertiesClass.getMensaje();
    }
}
