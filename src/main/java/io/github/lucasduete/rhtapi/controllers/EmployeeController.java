package io.github.lucasduete.rhtapi.controllers;

import io.github.lucasduete.rhtapi.models.Employee;
import io.github.lucasduete.rhtapi.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity saveEmployee(@RequestBody Employee employee) {

        if (employee == null) return ResponseEntity.badRequest().body("Employee not be null");

        Employee employeeSaved = this.service.save(employee);

        if (employeeSaved != null) return ResponseEntity.ok(employeeSaved);
        else return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Occurred error while saving employee");
    }

    @GetMapping
    public ResponseEntity listEmployee() {
        return ResponseEntity.ok(this.service.findAll());
    }

    @PostMapping("login")
    public ResponseEntity login(@RequestParam(name = "email", required = true) String email,
                                @RequestParam(name = "password", required = true) String password) {

        if (email == null || email.isEmpty()) return ResponseEntity.badRequest().body("Email can't be null or empty");

        if (password == null || password.isEmpty())
            return ResponseEntity.badRequest().body("Password can't be null or empty");

        Employee employee = this.service.authenticate(email, password);

        if (employee != null) return ResponseEntity.ok(employee);
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
