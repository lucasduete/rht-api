package io.github.lucasduete.rhtapi.models;

import io.github.lucasduete.rhtapi.models.enums.TypeQuestion;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable
    private List<String> options;

    @OneToMany
    private List<Response> responses;

}
