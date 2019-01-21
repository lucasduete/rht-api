package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

}
