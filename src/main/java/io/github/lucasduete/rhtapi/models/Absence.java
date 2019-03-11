package io.github.lucasduete.rhtapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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

}