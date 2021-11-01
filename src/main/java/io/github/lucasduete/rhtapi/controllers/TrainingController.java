package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Training;
import io.github.lucasduete.rhtapi.services.TrainingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("training")
public class TrainingController {

    private final TrainingService service;

    public TrainingController(TrainingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveTraining(@RequestBody @Valid Training training) {
        if (training == null) return ResponseEntity.badRequest().body("Training can't be null");

        Training savedTraining = this.service.save(training);

        if (savedTraining != null) return ResponseEntity.status(HttpStatus.CREATED).body(savedTraining);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping
    public ResponseEntity listAll() {
        return ResponseEntity.ok(this.service.listAll());
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

}
