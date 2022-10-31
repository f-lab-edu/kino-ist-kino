package com.flab.kinoistkino.controller.api;

import com.flab.kinoistkino.ifs.CrudInterface;
import com.flab.kinoistkino.model.network.Header;
import com.flab.kinoistkino.model.network.request.ReviewApiRequest;
import com.flab.kinoistkino.model.network.response.ReviewApiResponse;
import com.flab.kinoistkino.service.ReviewApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/review")
public class ReviewApiController implements CrudInterface<ReviewApiRequest, ReviewApiResponse> {

    @Autowired
    private ReviewApiService reviewApiService;

    @Override
    @PostMapping
    public Header<ReviewApiResponse> create(@RequestBody Header<ReviewApiRequest> request) {
        return reviewApiService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ReviewApiResponse> read(@PathVariable Long id) {
        return reviewApiService.read(id);
    }

    @Override
    @PutMapping
    public Header<ReviewApiResponse> update(@RequestBody Header<ReviewApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
