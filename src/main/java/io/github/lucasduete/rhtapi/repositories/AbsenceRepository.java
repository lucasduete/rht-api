package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    public List<Absence> findByTraining_Id(Long trainingId);
}
