package com.example.springtutorial.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class ControladorMensagem {

    @GetMapping
    public String encontrarMensagem() {
        return "Opa!";
    }

    @RequestMapping(value = "/exemplo-request-mapping", method = RequestMethod.GET)
    public String encontrarMensagem2() {
        return "Opa!";
    }
}
