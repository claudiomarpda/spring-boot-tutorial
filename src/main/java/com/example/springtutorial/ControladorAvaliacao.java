package com.example.springtutorial;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes")
public class ControladorAvaliacao {

    final RepositorioAvaliacao repositorioAvaliacao;

    ControladorAvaliacao(RepositorioAvaliacao repositorioAvaliacao) {
        this.repositorioAvaliacao = repositorioAvaliacao;

        // Salva uma avaliação e exibe no console
        repositorioAvaliacao.save(new Avaliacao(4, "avaliação teste"));
        repositorioAvaliacao.findAll().forEach(System.out::println);
    }

    @GetMapping
    public Avaliacao obterAvaliacao() {
        return new Avaliacao(5, "Ótimo");
    }

    @GetMapping("/{id}")
    public Avaliacao obterAvaliacao(@PathVariable long id) {
        return repositorioAvaliacao.findById(id).orElse(null);
    }

    @PostMapping
    public void criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        System.out.println("Salvar avaliação \n" + avaliacao);
        repositorioAvaliacao.save(avaliacao);
    }

    @PutMapping("/{id}")
    public void atualizarAvaliacao(@PathVariable long id, @RequestBody Avaliacao avaliacao) {
        System.out.println("Atualizar parcialmente avaliação com id " + id);
    }

    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable long id) {
        System.out.println("Deletar avaliação com id " + id);
    }
}