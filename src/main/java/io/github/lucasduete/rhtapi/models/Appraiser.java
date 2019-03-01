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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appraiser appraiser = (Appraiser) o;
        return email.equals(appraiser.email) &&
                name.equals(appraiser.name) &&
                password.equals(appraiser.password) &&
                Objects.equals(trainings, appraiser.trainings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, trainings);
    }

    @Override
    public String toString() {
        return "Appraiser{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", trainings=" + trainings +
                '}';
    }
}
