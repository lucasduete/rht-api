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
@EqualsAndHashCode
@ToString
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

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    @JsonSetter("dateStart")
    public void setDateStart(String date) {
        this.setDateStart(convertStringToLocalDate(date));
    }

    @JsonGetter("dateStart")
    public String getDateStartJson() {
        return convertLocalDateToString(this.dateStart);
    }

    @JsonSetter("dateFinish")
    public void setDateFinish(String date) {
        this.setDateFinish(convertStringToLocalDate(date));
    }

    @JsonGetter("dateFinish")
    public String getDateFinishJson() {
        return convertLocalDateToString(this.dateFinish);
    }

    public Integer quantVacancyUsed() {
        return this.employees.size();
    }

    public Integer quantVacancyOpen() {
        return (this.vacancyOffered - this.quantVacancyUsed());
    }

    private LocalDate convertStringToLocalDate(String dateString) {
        return LocalDate.parse(dateString.split("T")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String convertLocalDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}