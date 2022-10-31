package com.flab.kinoistkino.controller.api;

import com.flab.kinoistkino.ifs.CrudInterface;
import com.flab.kinoistkino.model.network.Header;
import com.flab.kinoistkino.model.network.request.MovieApiRequest;
import com.flab.kinoistkino.model.network.response.MovieApiResponse;
import com.flab.kinoistkino.service.MovieApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movie")
public class MovieApiController implements CrudInterface<MovieApiRequest, MovieApiResponse> {


    @Autowired
    private MovieApiService movieApiService;

    @Override
    @PostMapping("")    // /api/movie
    public Header<MovieApiResponse> create(@RequestBody Header<MovieApiRequest> request) {
        return movieApiService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<MovieApiResponse> read(@PathVariable Long id) {

        return movieApiService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<MovieApiResponse> update(@RequestBody Header<MovieApiRequest> request) {

        return movieApiService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {

        return movieApiService.delete(id);
    }
}
