package io.github.lucasduete.rhtapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Appraiser implements Serializable {

    @Id
    @Column(length = 70)
    private String email;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Training> trainings;

}
