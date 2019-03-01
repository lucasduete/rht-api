package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository repository;

    public TrainingService(TrainingRepository repository) {
        this.repository = repository;
    }

    public Training save(Training training) {
        return this.repository.save(training);
    }

    public List<Training> listAll() {
        return this.repository.findAll();
    }

    public Training findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

}
