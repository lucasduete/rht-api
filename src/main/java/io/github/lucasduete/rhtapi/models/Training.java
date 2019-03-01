package io.github.lucasduete.rhtapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Training implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    private Integer vacancyOffered;

    private Integer quantLesson;

    private Integer quantHrsLesson;

    @Column(nullable = false)
    private LocalDate dataStart;

    @Column(nullable = false)
    private LocalDate dateFinish;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Employee> employees;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Appraiser> appraisers;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Question> questions;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Rating> ratings;

    public Integer getVacancyUsed() {
        return this.employees.size();
    }

    public Integer getVacancyOpen() {
        return (this.vacancyOffered - this.getVacancyUsed());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) &&
                Objects.equals(name, training.name) &&
                Objects.equals(vacancyOffered, training.vacancyOffered) &&
                Objects.equals(quantLesson, training.quantLesson) &&
                Objects.equals(quantHrsLesson, training.quantHrsLesson) &&
                Objects.equals(dataStart, training.dataStart) &&
                Objects.equals(dateFinish, training.dateFinish) &&
                Objects.equals(employees, training.employees) &&
                Objects.equals(appraisers, training.appraisers) &&
                Objects.equals(questions, training.questions) &&
                Objects.equals(ratings, training.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vacancyOffered, quantLesson, quantHrsLesson, dataStart, dateFinish, employees, appraisers, questions, ratings);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancyOffered=" + vacancyOffered +
                ", quantLesson=" + quantLesson +
                ", quantHrsLesson=" + quantHrsLesson +
                ", dataStart=" + dataStart +
                ", dateFinish=" + dateFinish +
                ", employees=" + employees +
                ", appraisers=" + appraisers +
                ", questions=" + questions +
                ", ratings=" + ratings +
                '}';
    }

}