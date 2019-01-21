package io.github.lucasduete.rhtapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
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

    public Appraiser() {

    }

    public Appraiser(String email, String name, String password, List<Training> trainings) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.trainings = trainings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

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
