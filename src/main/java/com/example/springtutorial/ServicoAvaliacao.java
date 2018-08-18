package com.example.springtutorial;

import java.util.Optional;

public interface ServicoAvaliacao {

    Optional<Avaliacao> encontrarPorId(long id);
}
