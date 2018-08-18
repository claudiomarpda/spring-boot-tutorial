package com.example.springtutorial;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicoAvaliacaoImpl implements ServicoAvaliacao {

    private RepositorioAvaliacao repositorioAvaliacao;

    public ServicoAvaliacaoImpl(RepositorioAvaliacao repositorioAvaliacao) {
        this.repositorioAvaliacao = repositorioAvaliacao;
    }

    @Override
    public Optional<Avaliacao> encontrarPorId(long id) {
        return repositorioAvaliacao.findById(id);
    }
}
