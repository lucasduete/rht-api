package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Question;
import io.github.lucasduete.rhtapi.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("question")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("{idTraining}")
    public ResponseEntity saveQuestion(@RequestBody Question question,
                                       @PathVariable("idTraining") Long idTraining) {
        if (question == null) return ResponseEntity.badRequest().body("Question can't be null");
        if (idTraining == null) return ResponseEntity.badRequest().body("Id of Training can't be null");

        Question savedQuestion = this.service.save(question, idTraining);

        if (savedQuestion != null) return ResponseEntity.status(HttpStatus.CREATED).body(savedQuestion);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred error while saving question");
    }

    @DeleteMapping
    public ResponseEntity remove(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().body("Id param can't be null");

        this.service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity retreive(@PathVariable Long id) {
        if (id == null) return ResponseEntity.badRequest().body("Id param can't be null");

        Question question = this.service.getQuestion(id);

        if (question != null) return ResponseEntity.ok(question);
        else return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
