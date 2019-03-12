package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Employee;
import io.github.lucasduete.rhtapi.models.Rating;
import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.repositories.EmployeeRepository;
import io.github.lucasduete.rhtapi.repositories.RatingRepository;
import io.github.lucasduete.rhtapi.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final TrainingRepository trainingRepository;
    private final EmployeeRepository employeeRepository;

    public RatingService(RatingRepository ratingRepository, TrainingRepository trainingRepository, EmployeeRepository employeeRepository) {
        this.ratingRepository = ratingRepository;
        this.trainingRepository = trainingRepository;
        this.employeeRepository = employeeRepository;
    }

    public Rating save(Long idTraining, String emailEmployee, Integer points) {

        Optional<Training> trainingOptional = this.trainingRepository.findById(idTraining);
        Optional<Employee> employeeOptional = this.employeeRepository.findById(emailEmployee);

        if (!trainingOptional.isPresent() || !employeeOptional.isPresent())
            return null;

        Training training = trainingOptional.get();
        Employee employee = employeeOptional.get();

        boolean alreadExists = training.getRatings().stream().anyMatch(rating -> rating.getEmployee().equals(employee));

        if (alreadExists) {
            throw new RuntimeException("Alread Exists");
        }

        Rating rating = new Rating(points, training, employee);

        training.addRating(rating);

        this.trainingRepository.saveAndFlush(training);

        return rating;
    }

}
