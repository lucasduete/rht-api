package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Question;
import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.repositories.QuestionRepository;
import io.github.lucasduete.rhtapi.repositories.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questioRepository;
    private final TrainingRepository trainingRepository;

    public QuestionService(QuestionRepository questioRepository, TrainingRepository trainingRepository) {
        this.questioRepository = questioRepository;
        this.trainingRepository = trainingRepository;
    }

    public Question save(Question question, Long trainingId) {

        Optional<Training> trainingOptional = this.trainingRepository.findById(trainingId);

        if (!trainingOptional.isPresent()) return null;

        Training training = trainingOptional.get();

        training.addQuestion(question);
        this.trainingRepository.save(training);

        return question;
    }

    public Question save(Question question) {

        return this.questioRepository.save(question);
    }

    public Question getQuestion(Long id) {
        return this.questioRepository.getOne(id);
    }

    public void remove(Long id) {
        this.questioRepository.deleteById(id);
    }

}
