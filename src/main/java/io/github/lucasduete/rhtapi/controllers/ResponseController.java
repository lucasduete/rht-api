package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.controllers.valueobjects.ResponseModel;
import io.github.lucasduete.rhtapi.models.Response;
import io.github.lucasduete.rhtapi.services.ResponseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("response")
public class ResponseController {

    private final ResponseService service;

    public ResponseController(ResponseService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveResponse(@RequestBody ResponseModel response) {
        if (response == null) return ResponseEntity.badRequest().body("Reponse can't be null");

        Response savedResponse = this.service.save(response);

        if (savedResponse != null) return ResponseEntity.status(HttpStatus.CREATED).body(response);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("list")
    public ResponseEntity saveResponses(@RequestBody List<ResponseModel> responses) {
        if (responses == null || responses.isEmpty())
            return ResponseEntity.badRequest().body("Reponse can't be null and can't be empty");


        List<Response> responsesSaved = new ArrayList<>();

        responses.forEach( responseModel -> {
            if (responseModel != null)
                responsesSaved.add(this.service.save(responseModel));
        });


        if (!responsesSaved.isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
