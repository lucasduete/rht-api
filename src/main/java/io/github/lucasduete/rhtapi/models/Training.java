package io.github.lucasduete.rhtapi.models;

import io.github.lucasduete.rhtapi.models.interfaces.Indicator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Training implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    private Integer vacancyOffered;

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

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Indicator> indicators;

    public Training() {

    }

    public Training(String name, Integer vacancyOffered, Integer quantHrsLesson, LocalDate dataStart,
                    LocalDate dateFinish, List<Employee> employees, List<Appraiser> appraisers,
                    List<Question> questions, List<Indicator> indicators) {
        this.name = name;
        this.vacancyOffered = vacancyOffered;
        this.quantHrsLesson = quantHrsLesson;
        this.dataStart = dataStart;
        this.dateFinish = dateFinish;
        this.employees = employees;
        this.appraisers = appraisers;
        this.questions = questions;
        this.indicators = indicators;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVacancyOffered() {
        return vacancyOffered;
    }

    public void setVacancyOffered(Integer vacancyOffered) {
        this.vacancyOffered = vacancyOffered;
    }

    public Integer getVacancyUsed() {
        return this.employees.size();
    }

    public Integer getVacancyOpen() {
        return (this.vacancyOffered - this.getVacancyUsed());
    }

    public Integer getQuantHrsLesson() {
        return quantHrsLesson;
    }

    public void setQuantHrsLesson(Integer quantHrsLesson) {
        this.quantHrsLesson = quantHrsLesson;
    }

    public LocalDate getDataStart() {
        return dataStart;
    }

    public void setDataStart(LocalDate dataStart) {
        this.dataStart = dataStart;
    }

    public LocalDate getDateFinish() {
        return dateFinish;
    }

    public void setDateFinish(LocalDate dateFinish) {
        this.dateFinish = dateFinish;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Appraiser> getAppraisers() {
        return appraisers;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void setAppraisers(List<Appraiser> appraisers) {
        this.appraisers = appraisers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Indicator> getIndicators() {
        return indicators;
    }

    public void setIndicators(List<Indicator> indicators) {
        this.indicators = indicators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return id.equals(training.id) &&
                name.equals(training.name) &&
                Objects.equals(vacancyOffered, training.vacancyOffered) &&
                Objects.equals(quantHrsLesson, training.quantHrsLesson) &&
                dataStart.equals(training.dataStart) &&
                Objects.equals(dateFinish, training.dateFinish) &&
                Objects.equals(employees, training.employees) &&
                Objects.equals(appraisers, training.appraisers) &&
                Objects.equals(questions, training.questions) &&
                Objects.equals(indicators, training.indicators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, vacancyOffered, quantHrsLesson, dataStart, dateFinish, employees,
                appraisers, questions, indicators);
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", vacancyOffered=" + vacancyOffered +
                ", quantHrsLesson=" + quantHrsLesson +
                ", dataStart=" + dataStart +
                ", dateFinish=" + dateFinish +
                ", employees=" + employees +
                ", appraisers=" + appraisers +
                ", questions=" + questions +
                ", indicators=" + indicators +
                '}';
    }

}