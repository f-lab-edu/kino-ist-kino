package com.flab.kinoistkino.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    // 1 : N
    // LAZY = 지연로딩 , EAGER = 즉시로딩
    // LAZY = SELECT * FROM movie where id = ? 처럼 선택한 id에 대한 값만 가져온다.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movie")
    private List<Review> reviewList;

}
