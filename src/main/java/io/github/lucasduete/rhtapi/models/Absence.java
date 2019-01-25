package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Absence implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate date;

    @Column(nullable = false)
    private Integer quant;

    @ManyToOne
    private Training training;

    @ManyToOne
    private Employee employee;

    public Absence() {

    }

    public Absence(LocalDate date, Integer quant, Training training, Employee employee) {
        this.date = date;
        this.quant = quant;
        this.training = training;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(id, absence.id) &&
                Objects.equals(date, absence.date) &&
                Objects.equals(quant, absence.quant) &&
                Objects.equals(training, absence.training) &&
                Objects.equals(employee, absence.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, quant, training, employee);
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", date=" + date +
                ", quant=" + quant +
                ", training=" + training +
                ", employee=" + employee +
                '}';
    }

}