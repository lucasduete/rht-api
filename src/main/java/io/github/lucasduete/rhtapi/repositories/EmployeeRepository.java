package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query("SELECT e FROM Employee e WHERE e.email = ?1 and e.password = ?2")
    Employee authenticate(String email, String password);
}
