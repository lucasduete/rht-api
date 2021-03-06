package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Appraiser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppraiserRepository extends JpaRepository<Appraiser, String> {

    @Query("SELECT a FROM Appraiser a WHERE a.email = ?1 and a.password = ?2")
    Appraiser authenticate(String email, String password);

}
