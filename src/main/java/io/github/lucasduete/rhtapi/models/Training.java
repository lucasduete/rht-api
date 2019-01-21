package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Training {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dataStart;

    @Column(nullable = false)
    private LocalDate dateFinish;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> employees;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Appraiser> appraisers;


}
