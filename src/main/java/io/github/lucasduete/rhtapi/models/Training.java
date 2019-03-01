package io.github.lucasduete.rhtapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private LocalDate dateStart;

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

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    @JsonSetter("dateStart")
    public void setDateStart(String date) {
        this.setDateStart(convertDate(date));
    }

    @JsonGetter("dateStart")
    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    @JsonSetter("dateFinish")
    public void setDateFinish(String date) {
        this.setDateFinish(convertDate(date));
    }

    @JsonGetter("dateFinish")
    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public Integer quantVacancyUsed() {
        return this.employees.size();
    }

    public Integer quantVacancyOpen() {
        return (this.vacancyOffered - this.quantVacancyUsed());
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
                Objects.equals(dateStart, training.dateStart) &&
                Objects.equals(dateFinish, training.dateFinish) &&
                Objects.equals(employees, training.employees) &&
                Objects.equals(appraisers, training.appraisers) &&
                Objects.equals(questions, training.questions) &&
                Objects.equals(ratings, training.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vacancyOffered, quantLesson, quantHrsLesson, dateStart, dateFinish, employees, appraisers, questions, ratings);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancyOffered=" + vacancyOffered +
                ", quantLesson=" + quantLesson +
                ", quantHrsLesson=" + quantHrsLesson +
                ", dateStart=" + dateStart +
                ", dateFinish=" + dateFinish +
                ", employees=" + employees +
                ", appraisers=" + appraisers +
                ", questions=" + questions +
                ", ratings=" + ratings +
                '}';
    }

    private LocalDate convertDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}