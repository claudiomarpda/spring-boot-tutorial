package com.example.springtutorial.controlador.rest;

import com.example.springtutorial.repositorio.RepositorioAvaliacao;
import com.example.springtutorial.modelo.Avaliacao;
import com.example.springtutorial.servico.ServicoAvaliacao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class ControladorAvaliacao {

   private final RepositorioAvaliacao repositorioAvaliacao;
   private final ServicoAvaliacao servicoAvaliacao;

    public ControladorAvaliacao(RepositorioAvaliacao ra, ServicoAvaliacao sa) {
        this.repositorioAvaliacao = ra;
        this.servicoAvaliacao = sa;

        // Salva avaliações e exibe no console
        repositorioAvaliacao.save(new Avaliacao(5, "Ótimo"));
        repositorioAvaliacao.save(new Avaliacao(4, "Bom"));
        repositorioAvaliacao.save(new Avaliacao(4, "Muito bom"));
        repositorioAvaliacao.findAll().forEach(System.out::println);
    }

    public @GetMapping
    Avaliacao encontrar() {
        return new Avaliacao(5, "Ótimo");
    }

    @GetMapping("/{id}")
    public Avaliacao encontrar(@PathVariable long id) {
        return servicoAvaliacao.encontrarPorId(id).orElse(null);
    }

    @PostMapping
    public void criar(@RequestBody Avaliacao avaliacao) {
        System.out.println("Salvar avaliação \n" + avaliacao);
        repositorioAvaliacao.save(avaliacao);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable long id, @RequestBody Avaliacao avaliacao) {
        System.out.println("Atualizar parcialmente avaliação com id " + id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable long id) {
        System.out.println("Deletar avaliação com id " + id);
    }

    @GetMapping(params = "classificacao")
    public Iterable<Avaliacao> encontrarPorClassificacao(@RequestParam int classificacao) {
        return repositorioAvaliacao.findByClassificacaoEquals(classificacao);
    }

    @GetMapping(params = "comentario")
    public List<Avaliacao> encontrarPorComentario(@RequestParam String comentario) {
        return repositorioAvaliacao.findByComentarioContainingIgnoreCase(comentario);
    }
}