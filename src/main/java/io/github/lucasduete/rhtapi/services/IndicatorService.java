package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.indicators.implementations.RatingIndicator;
import io.github.lucasduete.rhtapi.indicators.implementations.VacancyIndicator;
import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IndicatorService {

    private final TrainingRepository trainingRepository;

    public IndicatorService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public String calculateRatingIndicator(Long idTraining) {

        Optional<Training> trainingOptional = this.trainingRepository.findById(idTraining);

        if (!trainingOptional.isPresent()) return null;

        Training training = trainingOptional.get();

        return new RatingIndicator(training).calculate();
    }

    public String calculateVacancyIdicator(Long idTraining) {

        Optional<Training> trainingOptional = this.trainingRepository.findById(idTraining);

        if (!trainingOptional.isPresent()) return null;

        Training training = trainingOptional.get();

        return new VacancyIndicator(training).calculate();
    }

}
