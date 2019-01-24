package io.github.lucasduete.rhtapi.indicators;

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
    public Integer calculate() {

        Integer quantAbsence = this.service.listByTraining(this.training.getId()).size();

        return (this.training.getQuantLesson() - quantAbsence);
    }
}
