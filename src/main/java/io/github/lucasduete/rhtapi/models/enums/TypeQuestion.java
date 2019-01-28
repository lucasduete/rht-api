package io.github.lucasduete.rhtapi.models.enums;

import javax.persistence.Entity;
import java.io.Serializable;

public enum TypeQuestion implements Serializable {

    ABERTA("Aberta"),
    SELECIONADA("Selecionada"),
    PONTUACAO("Pontuacao");

    private String name;

    TypeQuestion(String naome) {
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
