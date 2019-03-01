package io.github.lucasduete.rhtapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
