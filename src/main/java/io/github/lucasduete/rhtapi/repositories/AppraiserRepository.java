package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Appraiser;
import io.github.lucasduete.rhtapi.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraiserRepository extends JpaRepository<Appraiser, String> {

    @Query("SELECT a FROM Appraiser a WHERE a.Email = ?1 and a.Password = ?2")
    Employee authenticate(String email, String password);
}
