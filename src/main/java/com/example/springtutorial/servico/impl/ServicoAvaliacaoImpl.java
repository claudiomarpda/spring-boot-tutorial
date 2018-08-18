package com.example.springtutorial.servico.impl;

import com.example.springtutorial.modelo.Avaliacao;
import com.example.springtutorial.repositorio.RepositorioAvaliacao;
import com.example.springtutorial.servico.ServicoAvaliacao;
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
