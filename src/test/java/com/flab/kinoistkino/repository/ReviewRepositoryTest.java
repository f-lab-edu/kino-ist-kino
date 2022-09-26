package com.flab.kinoistkino.repository;

import com.flab.kinoistkino.KinoIstKinoApplicationTests;
import com.flab.kinoistkino.model.entity.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class ReviewRepositoryTest extends KinoIstKinoApplicationTests {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void create(){
        Review review = new Review();

        // 어떤 사람이
        //review.setUserId(11L);
        // 어떤 영화는 선택했는지에 대한 인덱스 ID 필요
        //review.setMovieId(2L);
        review.setName("Jun");
        review.setContent("무서웠다.");
        review.setRate(5.0F);
        review.setCreatedAt(LocalDateTime.now());
        review.setUpdatedAt(LocalDateTime.now());

        Review newReview = reviewRepository.save(review);
        Assertions.assertNotNull(newReview);

    }

    @Test
    public void read(){
        Long id = 1L;

        Optional<Review> review = reviewRepository.findById(id);

        Assertions.assertTrue(review.isPresent());


    }
}
