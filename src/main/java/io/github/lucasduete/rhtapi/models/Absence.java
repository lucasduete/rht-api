package io.github.lucasduete.rhtapi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Absence absence = (Absence) o;
        return Objects.equals(id, absence.id) &&
                Objects.equals(date, absence.date) &&
                Objects.equals(quant, absence.quant) &&
                Objects.equals(training, absence.training) &&
                Objects.equals(employee, absence.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, quant, training, employee);
    }

    @Override
    public String toString() {
        return "Absence{" +
                "id=" + id +
                ", date=" + date +
                ", quant=" + quant +
                ", training=" + training +
                ", employee=" + employee +
                '}';
    }

}