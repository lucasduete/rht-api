package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.controllers.valueobjects.IndicatorResponse;
import io.github.lucasduete.rhtapi.services.IndicatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("indicator")
public class IndicatorController {

    private final IndicatorService indicatorService;

    public IndicatorController(IndicatorService indicatorService) {
        this.indicatorService = indicatorService;
    }

    @GetMapping("rating/{idTraining}")
    public ResponseEntity ratingIdicator(@PathVariable("idTraining") Long idTraining) {

        return processResponseEntity(
                this.indicatorService.calculateRatingIndicator(idTraining)
        );
    }

    @GetMapping("vacancy/{idTraining}")
    public ResponseEntity vacancyIdicator(@PathVariable("idTraining") Long idTraining) {

        return processResponseEntity(
                this.indicatorService.calculateVacancyIdicator(idTraining)
        );
    }

    private ResponseEntity processResponseEntity(String indicator) {

        if (indicator ==  null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(new IndicatorResponse(indicator));
        }
    }

}
