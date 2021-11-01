package io.github.lucasduete.rhtapi.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.github.lucasduete.rhtapi.models.enums.TypeQuestion;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Size(min = 10)
    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private TypeQuestion typeQuestion;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable
    private List<String> options;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "question")
    @JsonManagedReference
    private List<Response> responses;

    {
        this.options = new ArrayList<>();
        this.responses = new ArrayList<>();
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void addResponse(Response response) {
        this.responses.add(response);
    }

}
