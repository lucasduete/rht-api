package io.github.lucasduete.rhtapi.indicators.implementations;

import io.github.lucasduete.rhtapi.indicators.interfaces.Indicator;
import io.github.lucasduete.rhtapi.models.Absence;
import io.github.lucasduete.rhtapi.models.Training;

import java.util.List;

public class GoalsIndicator implements Indicator {

    private Training training;
    private List<Absence> absences;

    public GoalsIndicator(Training training, List<Absence> absences) {
        this.training = training;
        this.absences = absences;
    }

    @Override
    public Integer calculate() {

        Integer quantHrsLesson = this.training.getQuantHrsLesson();

        for (Absence absence : absences) quantHrsLesson -= (absence.getQuant() * 60);

        return quantHrsLesson;
    }
}
