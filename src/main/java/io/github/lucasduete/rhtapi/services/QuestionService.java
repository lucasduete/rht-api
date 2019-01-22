package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Question;
import io.github.lucasduete.rhtapi.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question save(Question question) {
        return this.repository.save(question);
    }

    public Question getQuestion(Long id) {
        return this.repository.getOne(id);
    }

    public void remove(Long id) {
        this.repository.deleteById(id);
    }

}
