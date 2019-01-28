package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Appraiser;
import io.github.lucasduete.rhtapi.services.AppraiserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appraiser")
public class AppraiserController {

    private final AppraiserService service;

    public AppraiserController(AppraiserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveAppraiser(@RequestBody Appraiser appraiser) {
        if (appraiser == null)
            return ResponseEntity.badRequest().body("Appraiser can't be null");

        Appraiser appraiserSaved = service.save(appraiser);

        if (appraiserSaved != null) return ResponseEntity.ok(appraiserSaved);
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred error while saving appraiser");
    }

    @GetMapping
    public ResponseEntity listAppraiser() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestParam(name = "email", required = true) String email,
                                @RequestParam(name = "password", required = true) String password) {

        if (email == null || email.isEmpty()) return ResponseEntity.badRequest().body("Email can't be null or empty");

        if (password == null || password.isEmpty())
            return ResponseEntity.badRequest().body("Password can't be null or empty");

        Appraiser appraiser = this.service.authenticate(email, password);

        if (appraiser != null) return ResponseEntity.ok(appraiser);
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
