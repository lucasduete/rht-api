package io.github.lucasduete.rhtapi.models;

import io.github.lucasduete.rhtapi.models.enums.TypeQuestion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(id, question1.id) &&
                question.equals(question1.question) &&
                typeQuestion.equals(question1.typeQuestion) &&
                Objects.equals(options, question1.options) &&
                Objects.equals(responses, question1.responses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, typeQuestion, options, responses);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", typeQuestion=" + typeQuestion +
                ", options=" + options +
                ", responses=" + responses +
                '}';
    }
}
