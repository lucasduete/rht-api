package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String question;

    @OneToMany(fetch = FetchType.LAZY)
    private List<String> options;
}
