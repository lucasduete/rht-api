package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Rating;
import io.github.lucasduete.rhtapi.repositories.RatingRepository;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository repository;

    public RatingService(RatingRepository repository) {
        this.repository = repository;
    }

    public void save(Rating rating) {
        this.repository.save(rating);
    }

}
