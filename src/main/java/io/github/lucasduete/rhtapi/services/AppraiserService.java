package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Appraiser;
import io.github.lucasduete.rhtapi.repositories.AppraiserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppraiserService {

    private final AppraiserRepository repository;

    public AppraiserService(AppraiserRepository repository) {
        this.repository = repository;
    }

    public Appraiser save(Appraiser appraiser) {
        return this.repository.save(appraiser);
    }

    public Appraiser findByEmail(String email) {
        if (email != null && !email.isEmpty()) return this.repository.getOne(email);
        else return null;
    }

    public List<Appraiser> findAll() {
        return this.repository.findAll();
    }

    public Appraiser authenticate(String email, String password) {
        return this.repository.authenticate(email, password);
    }

}
