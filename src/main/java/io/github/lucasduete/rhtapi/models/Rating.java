package io.github.lucasduete.rhtapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

}
