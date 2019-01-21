package io.github.lucasduete.rhtapi.models;

import io.github.lucasduete.rhtapi.models.enums.TypeQuestion;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
public class Question implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    private Enum<TypeQuestion> typeQuestion;

    @OneToMany(fetch = FetchType.LAZY)
    private List<String> options;

    @OneToMany
    private List<Response> responses;

    public Question() {

    }

    public Question(String question, Enum<TypeQuestion> typeQuestion, List<String> options, List<Response> responses) {
        this.question = question;
        this.typeQuestion = typeQuestion;
        this.options = options;
        this.responses = responses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Enum<TypeQuestion> getTypeQuestion() {
        return typeQuestion;
    }

    public void setTypeQuestion(Enum<TypeQuestion> typeQuestion) {
        this.typeQuestion = typeQuestion;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }

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
