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

    public void setPoints(Integer points) {
        // Validate the limits of points
        if (points > 7) points = 7;
        if (points < 0) points = 0;

        this.points = points;
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
