package io.github.lucasduete.rhtapi.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import io.github.lucasduete.rhtapi.controllers.validators.training.TrainingDatesValidator;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@TrainingDatesValidator
public class Training implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min = 10, max = 100)
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
    @JsonManagedReference
    private List<Employee> employees;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Appraiser> appraisers;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "training")
    @JsonManagedReference
    private List<Rating> ratings;

    {
        this.employees = new ArrayList<>();
        this.appraisers = new ArrayList<>();
        this.questions = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    @JsonSetter("dateStart")
    public void setDateStart(String date) {
        this.setDateStart(convertStringToLocalDate(date));
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    @JsonSetter("dateFinish")
    public void setDateFinish(String date) {
        this.setDateFinish(convertStringToLocalDate(date));
    }

    @JsonGetter("dateStart")
    public String getDateStartJson() {
        return convertLocalDateToString(this.dateStart);
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

    // METHODS TO ADD ELEMENTS TO ATTRIBUTES THAT ARE LIST

    public void addEmployee(@NotNull final Employee employee) {
        this.employees.add(employee);
    }

    public void addAppraiser(@NotNull final Appraiser appraiser) {
        this.appraisers.add(appraiser);
    }

    public void addQuestion(@NotNull final Question question) {
        this.questions.add(question);
    }

    public void addRating(@NotNull final Rating rating) {
        this.ratings.add(rating);
    }

    // METHODS AUXILIARIES

    private LocalDate convertStringToLocalDate(String dateString) {
        return LocalDate.parse(dateString.split("T")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    private String convertLocalDateToString(LocalDate localDate) {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

}