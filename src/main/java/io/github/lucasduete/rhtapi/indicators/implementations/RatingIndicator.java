package io.github.lucasduete.rhtapi.indicators.implementations;

import io.github.lucasduete.rhtapi.indicators.interfaces.Indicator;
import io.github.lucasduete.rhtapi.models.Training;

public class RatingIndicator implements Indicator {

    private Training training;

    public RatingIndicator(Training training) {
        this.training = training;
    }

    @Override
    public String calculate() {

        Long ratingHigh = training.getRatings().stream().filter(rating -> rating.getPoints() >= 5).count();

        return String.valueOf((training.getRatings().size() - ratingHigh.intValue()) * 100) + "pts";
    }

}
