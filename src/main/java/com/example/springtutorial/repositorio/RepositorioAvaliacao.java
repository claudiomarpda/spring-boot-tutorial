package com.example.springtutorial.repositorio;

import com.example.springtutorial.modelo.Avaliacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioAvaliacao extends CrudRepository<Avaliacao, Long> {

    List<Avaliacao> findByClassificacaoEquals(int classificacao);

    @Query("select a from Avaliacao a where a.classificacao = :classificacao")
    List<Avaliacao> encontrarPorClassificacaoJPA(@Param("classificacao") int classificacao);

    @Query(value = "select * from avaliacao where classificacao = :classificacao", nativeQuery = true)
    List<Avaliacao> encontrarPorClassificacaoSQLNativa(@Param("classificacao") int classificacao);

    List<Avaliacao> findByComentarioContainingIgnoreCase(String comentario);

}
