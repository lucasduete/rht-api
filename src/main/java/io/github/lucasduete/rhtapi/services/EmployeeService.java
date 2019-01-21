package io.github.lucasduete.rhtapi.services;

import io.github.lucasduete.rhtapi.models.Employee;
import io.github.lucasduete.rhtapi.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee employee) {
        if (employee != null) return this.repository.save(employee);
        else return null;
    }

    public Employee findByEmail(String email) {
        if (email != null && !email.isEmpty()) return this.repository.getOne(email);
        else return null;
    }

    public List<Employee> findAll() {
        return this.repository.findAll();
    }

    public Employee authenticate(String email, String password) {
        return this.repository.authenticate(email, password);
    }

}
