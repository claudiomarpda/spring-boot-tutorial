package com.example.springtutorial.bean;

public class Refeicao {

    public Feijao feijao;

    public Refeicao(Feijao feijao) {
        this.feijao = feijao;
    }
}

class Feijao {}

class FeijaoPreto extends Feijao {
    @Override
    public String toString() {
        return "FeijaoPreto{}";
    }
}
