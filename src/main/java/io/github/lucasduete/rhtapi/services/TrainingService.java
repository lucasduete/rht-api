package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

    private final TrainingRepository repository;

    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public Training save(Training training) {
        return this.repository.save(training);
    }

}
