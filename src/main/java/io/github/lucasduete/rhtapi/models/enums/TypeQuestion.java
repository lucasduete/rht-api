package io.github.lucasduete.rhtapi.models.enums;

import java.io.Serializable;

public enum TypeQuestion implements Serializable {

    ABERTA("Aberta"),
    FECHADA("Fechada"),
    PONTUACAO("Pontuacao");

    private String name;

    TypeQuestion(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "name='" + name + '\'' +
                '}';
    }

}
