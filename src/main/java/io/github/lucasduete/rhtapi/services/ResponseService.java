package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Response;
import io.github.lucasduete.rhtapi.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

@Service
public class ResponseService {

    private final ResponseRepository repository;

    public ResponseService(ResponseRepository respository) {
        this.repository = respository;
    }

    public Response save(Response response) {
        return this.repository.save(response);
    }

}
