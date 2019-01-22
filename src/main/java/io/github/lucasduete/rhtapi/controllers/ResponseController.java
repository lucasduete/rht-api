package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Response;
import io.github.lucasduete.rhtapi.services.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ResponseController {

    private final ResponseService service;

    public ResponseController(ResponseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveResponse(@RequestBody Response response) {
        if (response == null) return ResponseEntity.badRequest().body("Reponse can't be null");

        Response savedResponse = this.service.save(response);

        if (savedResponse != null) return ResponseEntity.status(HttpStatus.CREATED).body(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
