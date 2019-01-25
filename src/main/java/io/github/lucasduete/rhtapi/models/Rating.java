package io.github.lucasduete.rhtapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Training training;

    @ManyToOne
    private Employee employee;

    public Rating() {

    }

    public Rating(Training training, Employee employee) {
        this.training = training;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        Rating rating = (Rating) o;
        return Objects.equals(id, rating.id) &&
                Objects.equals(training, rating.training) &&
                Objects.equals(employee, rating.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, training, employee);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", training=" + training +
                ", employee=" + employee +
                '}';
    }

}
