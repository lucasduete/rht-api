package io.github.lucasduete.rhtapi.repositories;

import io.github.lucasduete.rhtapi.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

}
