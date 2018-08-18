package com.example.springtutorial.servico;

import com.example.springtutorial.modelo.Avaliacao;

import java.util.Optional;

public interface ServicoAvaliacao {

    Optional<Avaliacao> encontrarPorId(long id);
}
