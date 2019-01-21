package io.github.lucasduete.rhtapi.models.interfaces;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public interface Indicator extends Serializable {

    public Long calculate();
}
