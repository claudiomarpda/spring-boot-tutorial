package com.example.springtutorial;

import javax.persistence.*;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue
    private long id;

    private int classificacao;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(long id, int classificacao, String comentario) {
        this.id = id;
        this.classificacao = classificacao;
        this.comentario = comentario;
    }

    public Avaliacao(int classificacao, String comentario) {
        this.classificacao = classificacao;
        this.comentario = comentario;
    }

    public long getId() {
        return id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "id=" + id +
                ", classificacao=" + classificacao +
                ", comentario='" + comentario + '\'' +
                '}';
    }

}
