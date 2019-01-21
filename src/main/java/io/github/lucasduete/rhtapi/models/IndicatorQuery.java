package io.github.lucasduete.rhtapi.models;

import io.github.lucasduete.rhtapi.models.interfaces.Indicator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class IndicatorQuery implements Indicator {

    @Id
    private String name;

    @Column(nullable = false)
    private String query;

    public IndicatorQuery() {

    }

    public IndicatorQuery(String name, String query) {
        this.name = name;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndicatorQuery that = (IndicatorQuery) o;
        return name.equals(that.name) &&
                query.equals(that.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, query);
    }

    @Override
    public String toString() {
        return "IndicatorQuery{" +
                "name='" + name + '\'' +
                ", query='" + query + '\'' +
                '}';
    }

    @Override
    public Long calculate() {
        return null;
    }
}
