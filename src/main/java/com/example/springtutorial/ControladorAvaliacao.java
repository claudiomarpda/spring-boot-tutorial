package com.example.springtutorial;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class ControladorAvaliacao {

    @GetMapping
    public Avaliacao obterAvaliacao() {
        return new Avaliacao(5, "Ótimo");
    }

    @GetMapping("/{id}")
    public Avaliacao obterAvaliacao(@PathVariable long id) {
        return new Avaliacao(id, 5, "Ótimo");
    }

    @PostMapping
    public void criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        System.out.println(avaliacao);
    }

    @PatchMapping
    public void atualizarAvaliacao(@RequestBody Avaliacao avaliacao) {
        System.out.println(avaliacao);
    }
}