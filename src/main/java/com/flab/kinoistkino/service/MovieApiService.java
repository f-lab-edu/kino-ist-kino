package com.flab.kinoistkino.service;

import com.flab.kinoistkino.ifs.CrudInterface;
import com.flab.kinoistkino.model.entity.Movie;
import com.flab.kinoistkino.model.network.Header;
import com.flab.kinoistkino.model.network.request.MovieApiRequest;
import com.flab.kinoistkino.model.network.response.MovieApiResponse;
import com.flab.kinoistkino.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MovieApiService implements CrudInterface<MovieApiRequest, MovieApiResponse> {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Header<MovieApiResponse> create(Header<MovieApiRequest> request) {

        MovieApiRequest body = request.getData();

        Movie movie = Movie.builder()
                .genres(body.getGenres())
                .overview(body.getOverview())
                .rateAverage(body.getRateAverage())
                .releaseDate(LocalDateTime.now())
                .title(body.getTitle())
                .build();

        Movie newMovie = movieRepository.save(movie);
        return response(newMovie);
    }

    @Override
    public Header<MovieApiResponse> read(Long id) {

       return movieRepository.findById(id)
                .map(movie -> response(movie))
                .orElseGet(()-> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<MovieApiResponse> update(Header<MovieApiRequest> request) {

        Optional<Movie> byId = movieRepository.findById(request.getData().getId());
        byId.ifPresent(user ->{
            movieRepository.save(request.getData().toEntity());
        });

        /* .orElseGet()-> Header.ERROR("데이터 없음");*/

        return Header.OK();
    }

    @Override
    public Header delete(Long id) {

        return movieRepository.findById(id)
                .map(movie -> {
                    movieRepository.delete(movie);
                            return Header.OK();
                })
                .orElseGet(()->Header.ERROR("데이터 없음"));

    }

    private Header<MovieApiResponse> response(Movie movie){

        MovieApiResponse body = MovieApiResponse.builder()
                .id(movie.getId())
                .genres(movie.getGenres())
                .overview(movie.getOverview())
                .rateAverage(movie.getRateAverage())
                .releaseDate(LocalDateTime.now())
                .title(movie.getTitle())
                .build();

        return Header.OK(body);

    }
}
