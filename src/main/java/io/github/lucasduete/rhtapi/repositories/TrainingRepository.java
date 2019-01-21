package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

}
