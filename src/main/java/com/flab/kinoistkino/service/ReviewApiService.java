package com.flab.kinoistkino.service;

import com.flab.kinoistkino.ifs.CrudInterface;
import com.flab.kinoistkino.model.entity.Review;
import com.flab.kinoistkino.model.network.Header;
import com.flab.kinoistkino.model.network.request.ReviewApiRequest;
import com.flab.kinoistkino.model.network.response.ReviewApiResponse;
import com.flab.kinoistkino.repository.MovieRepository;
import com.flab.kinoistkino.repository.ReviewRepository;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewApiService implements CrudInterface<ReviewApiRequest, ReviewApiResponse> {

    @Autowired
    private ReviewRepository reviewRepository;

    // 누가 쓴 리뷰인지
    @Autowired
    private UserRepository userRepository;

    // 어떤 영화에 대한 리뷰인지 연결 시켜 줘야 해서 import 해줌
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Header<ReviewApiResponse> create(Header<ReviewApiRequest> request) {

        ReviewApiRequest body = request.getData();

        Review.ReviewBuilder builder = Review.builder();
        builder.content(body.getContent());
        builder.createdAt(LocalDateTime.now());
        builder.name(body.getName());
        builder.rate(body.getRate());
        builder.updatedAt(LocalDateTime.now());
        builder.movie(movieRepository.getReferenceById(body.getMovieId()));
        builder.user(userRepository.getReferenceById(body.getUserId()));
        Review review = builder
                .build();

        Review newReview = reviewRepository.save(review);


        return response(newReview);
    }

    @Override
    public Header<ReviewApiResponse> read(Long id) {

        return reviewRepository.findById(id)
                .map(review -> response(review))
                .orElseGet(()->Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<ReviewApiResponse> update(Header<ReviewApiRequest> request) {

        return null;
    }

    @Override
    public Header delete(Long id) {

        return null;
    }

    private Header<ReviewApiResponse> response(Review review){

        ReviewApiResponse body = ReviewApiResponse.builder()
                .id(review.getId())
                .content(review.getContent())
                .createdAt(LocalDateTime.now())
                .name(review.getName())
                .rate(review.getRate())
                .updatedAt(LocalDateTime.now())
                .movieId(review.getMovie().getId())
                .userId(review.getUser().getId())
                .build();

        return Header.OK(body);

    }

}
