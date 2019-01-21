package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
