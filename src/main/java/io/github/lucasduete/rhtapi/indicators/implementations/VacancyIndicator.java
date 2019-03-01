package io.github.lucasduete.rhtapi.indicators.implementations;

import io.github.lucasduete.rhtapi.indicators.interfaces.Indicator;
import io.github.lucasduete.rhtapi.models.Training;

public class VacancyIndicator implements Indicator {

    private Training training;

    public VacancyIndicator(Training training) {
        this.training = training;
    }

    @Override
    public Integer calculate() {
        return (this.training.quantVacancyUsed() / this.training.getVacancyOffered()) * 100;
    }

}
