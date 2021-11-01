package io.github.lucasduete.rhtapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Rating implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(nullable = false)
    private Integer points;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", nullable = false)
    @JsonBackReference
    private Training training;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_email", nullable = false)
    private Employee employee;

    public Rating(Integer points, Training training, Employee employee) {
        this.points = points;
        this.training = training;
        this.employee = employee;
    }

    public void setPoints(Integer points) {
        // Validate the limits of points
        if (points > 7) points = 7;
        if (points < 0) points = 0;

        this.points = points;
    }

}
