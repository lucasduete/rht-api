package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Rating;
import io.github.lucasduete.rhtapi.repositories.RatingRepository;
import io.github.lucasduete.rhtapi.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rating")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @PostMapping
    public ResponseEntity send(@RequestParam(name = "idTraining", required = true) Long idTraining,
                               @RequestParam(name = "emailEmployee", required = true) String emailEmployee,
                               @RequestParam(name = "points", required = true) Integer points) {

        if (idTraining == null || idTraining <= 0) {
            return ResponseEntity.badRequest().body("A valid Training's id is required");

        } else if (emailEmployee == null || emailEmployee.isEmpty()) {
            return ResponseEntity.badRequest().body("A valid Employee's email is required");

        } else if (points == null || points < 0 || points > 7) {
            return ResponseEntity.badRequest().body("Points must be in range [0 - 7] ");

        }

        try {

            Rating ratingSaved = this.ratingService.save(idTraining, emailEmployee, points);

            if (ratingSaved == null) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.ok(ratingSaved);
            }

        } catch (RuntimeException rex) {
            rex.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }

    }

}
