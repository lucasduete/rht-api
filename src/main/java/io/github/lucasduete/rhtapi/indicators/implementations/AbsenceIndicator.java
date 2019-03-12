package io.github.lucasduete.rhtapi.indicators.implementations;

import io.github.lucasduete.rhtapi.indicators.interfaces.Indicator;
import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.services.AbsenceService;

public class AbsenceIndicator implements Indicator {

    private AbsenceService service;
    private Training training;

    public AbsenceIndicator(AbsenceService service, Training training) {
        this.service = service;
        this.training = training;
    }

    @Override
    public String calculate() {

        Integer quantAbsence = this.service.listByTraining(this.training.getId()).size();

        return String.valueOf(this.training.getQuantLesson() - quantAbsence);
    }
}
