package com.example.springtutorial.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefeicaoConfig {

    @Bean
    Refeicao prepararRefeicao() {
        return new Refeicao(new FeijaoPreto());
    }
}