package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Rating implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer points;

    @ManyToOne
    private Training training;

    @ManyToOne
    private Employee employee;

    public Rating() {

    }

    public Rating(Integer points, Training training, Employee employee) {
        this.points = points;
        this.training = training;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        // Validate the limits of points
        if (points > 7) points = 7;
        if (points < 0) points = 0;

        this.points = points;
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
                Objects.equals(points, rating.points) &&
                Objects.equals(training, rating.training) &&
                Objects.equals(employee, rating.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, points, training, employee);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", points=" + points +
                ", training=" + training +
                ", employee=" + employee +
                '}';
    }

}
