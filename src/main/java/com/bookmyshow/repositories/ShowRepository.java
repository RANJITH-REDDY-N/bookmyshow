package com.bookmyshow.repositories;

import com.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    List<Show> findByMovieId(int movieId); // Find shows by movie
    List<Show> findByScreenId(int screenId); // Find shows by screen
}
