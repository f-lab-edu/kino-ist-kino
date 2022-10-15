package com.flab.kinoistkino.model.entity;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime releaseDate;

    private String overview;

    private Float rateAverage;

    private String actor;

    private String genre;

    private String director;

    @Builder
    public Movie(String title, LocalDateTime releaseDate, String overview, Float rateAverage, String actor, String genre, String director) {

        Assert.notNull(title, "title must not be null");
        Assert.hasText(String.valueOf(releaseDate), "releaseDate must not be empty");
        Assert.hasText(String.valueOf(overview), "overview must not be empty");
        Assert.notNull(String.valueOf(rateAverage), "rateAverage must not be null");
        Assert.hasText(String.valueOf(actor), "actor must not be empty");
        Assert.notNull(String.valueOf(genre), "genre must not be null");
        Assert.hasText(String.valueOf(director), "director must not be empty");

        this.title = title;
        this.actor = actor;
        this.genre = genre;
        this.director = director;
        this.overview = overview;
        this.rateAverage = rateAverage;
        this.releaseDate = releaseDate;

    }

    // 1 : N
    // LAZY = 지연로딩 , EAGER = 즉시로딩
    // LAZY = SELECT * FROM movie where id = ? 처럼 선택한 id에 대한 값만 가져온다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Review> reviewList;

}
