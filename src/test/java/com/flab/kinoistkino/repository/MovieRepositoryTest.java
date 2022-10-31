package com.flab.kinoistkino.repository;

import com.flab.kinoistkino.KinoIstKinoApplicationTests;
import com.flab.kinoistkino.model.entity.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class MovieRepositoryTest extends KinoIstKinoApplicationTests {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void create(){

        Movie movie = Movie.builder()
                .title("테스트3")
                .releaseDate(LocalDateTime.now())
                .overview("거미가 무섭다")
                /*.rateAverage(5.0f)*/
                .genres("판타지")
                .build();
/*        movie.setTitle("스파이더맨");
        movie.setReleaseDate(LocalDateTime.now());
        movie.setOverview("거미가 무섭다");
        movie.setRateAverage(5.0f);
        movie.setActor("스파이더맨");
        movie.setGenre("판타지");
        movie.setDirector("몰라");*/

        Movie newMovie = movieRepository.save(movie);
        Assertions.assertNotNull(newMovie);

    }

    @Test
    public void read(){
         Long id = 1L;

        Optional<Movie> movie = movieRepository.findById(id);

        Assertions.assertTrue(movie.isPresent());
    }

}
