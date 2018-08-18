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

    public ControladorAvaliacao(RepositorioAvaliacao repositorioAvaliacao, ServicoAvaliacao servicoAvaliacao) {
        this.repositorioAvaliacao = repositorioAvaliacao;
        this.servicoAvaliacao = servicoAvaliacao;

        // Salva avaliações e exibe no console
        repositorioAvaliacao.save(new Avaliacao(5, "Ótimo"));
        repositorioAvaliacao.save(new Avaliacao(4, "Bom"));
        repositorioAvaliacao.save(new Avaliacao(4, "Muito bom"));
        repositorioAvaliacao.findAll().forEach(System.out::println);
    }

    @GetMapping("/estatica")
    public Avaliacao encontrarAvaliacao() {
        return new Avaliacao(5, "Ótimo");
    }

    @GetMapping("/{id}")
    public Avaliacao encontrarAvaliacao(@PathVariable long id) {
        return servicoAvaliacao.encontrarPorId(id).orElse(null);
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

    @GetMapping(params = "classificacao")
    Iterable<Avaliacao> encontrarPorClassificacao(@RequestParam int classificacao) {
        return repositorioAvaliacao.findByClassificacaoEquals(classificacao);
    }

    @GetMapping(params = "comentario")
    public List<Avaliacao> encontrarPorComentario(@RequestParam String comentario) {
        return repositorioAvaliacao.findByComentarioContainingIgnoreCase(comentario);
    }
}