package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Response implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public Response() {

    }

    public Response(String content, Employee employee, Question question) {
        this.content = content;
        this.employee = employee;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response = (Response) o;
        return Objects.equals(id, response.id) &&
                content.equals(response.content) &&
                Objects.equals(employee, response.employee) &&
                Objects.equals(question, response.question);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, employee, question);
    }

    @Override
    public String toString() {
        return "Response{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", employee=" + employee +
                ", question=" + question +
                '}';
    }
}
