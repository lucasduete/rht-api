package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Absence;
import io.github.lucasduete.rhtapi.repositories.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    private AbsenceRepository repository;

    public AbsenceService(AbsenceRepository repository) {
        this.repository = repository;
    }

    public Absence save(Absence absence){
        return this.repository.save(absence);
    }

    public List<Absence> listByTraining(Long trainingId) {
        return this.repository.findByTraining_Id(trainingId);
    }

}
