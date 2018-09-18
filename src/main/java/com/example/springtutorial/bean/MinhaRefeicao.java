package com.example.springtutorial.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MinhaRefeicao {

    final Refeicao refeicao;

    @Autowired
    public MinhaRefeicao(Refeicao refeicao) {
        this.refeicao = refeicao;
        System.out.println("Refeicao com " + refeicao.feijao);
    }

}
