package com.flab.kinoistkino.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime releaseDate;

    private String overview;

    private Float rateAverage;

    private String genres;

    @Builder
    public Movie(String title, LocalDateTime releaseDate, String overview, Float rateAverage, String genres) {

        Assert.notNull(title, "title must not be null");
        Assert.hasText(String.valueOf(releaseDate), "releaseDate must not be empty");
        Assert.hasText(String.valueOf(overview), "overview must not be empty");
        Assert.notNull(String.valueOf(rateAverage), "rateAverage must not be null");
        Assert.notNull(String.valueOf(genres), "genre must not be null");

        this.title = title;
        this.genres = genres;
        this.overview = overview;
        this.rateAverage = rateAverage;
        this.releaseDate = releaseDate;

    }

    // 1 : N
    // LAZY = 지연로딩 , EAGER = 즉시로딩
    // LAZY = SELECT * FROM movie where id = ? 처럼 선택한 id에 대한 값만 가져온다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Review> reviewmovieList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Review> reviewuserList;

}
