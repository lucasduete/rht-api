package io.github.lucasduete.rhtapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    @Column(length = 70)
    private String email;

    @Column(length = 150, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;


}
