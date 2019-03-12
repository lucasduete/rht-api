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
    public String calculate() {

        Integer maxHrsLesson = this.training.getQuantHrsLesson();
        Integer finishedHrsLesson = new Integer(maxHrsLesson);

        for (Absence absence : absences) finishedHrsLesson -= (absence.getQuant() * 60);

        return String.valueOf((maxHrsLesson / finishedHrsLesson) * 100);
    }
}
