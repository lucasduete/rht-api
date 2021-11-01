package io.github.lucasduete.rhtapi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee implements Serializable {

    @Id
    @Email
    @Column(length = 70)
    private String email;

    @Size(min = 20, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @Size(min = 8, max = 50)
    @Column(length = 50, nullable = false)
    private String password;

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Training> trainings;

}
