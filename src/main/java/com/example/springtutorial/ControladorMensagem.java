package com.example.springtutorial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class ControladorMensagem {

    @GetMapping
    public String obterMensagem() {
        return "Opa!";
    }

    @RequestMapping(value = "/mensagem", method = RequestMethod.GET)
    public String obterMensagem2() {
        return "Opa!";
    }
}
