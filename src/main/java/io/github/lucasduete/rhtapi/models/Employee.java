package io.github.lucasduete.rhtapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    @Id
    @Column(length = 70)
    private String email;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 50, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Training> trainings;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return email.equals(employee.email) &&
                name.equals(employee.name) &&
                password.equals(employee.password) &&
                Objects.equals(trainings, employee.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, trainings);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", trainings=" + trainings +
                '}';
    }
}
