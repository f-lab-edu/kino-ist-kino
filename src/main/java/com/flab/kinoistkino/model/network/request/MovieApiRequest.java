package com.flab.kinoistkino.model.network.request;

import com.flab.kinoistkino.model.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieApiRequest {

    private Long id;

    private String genres;

    private String overview;

    private Float rateAverage;

    private LocalDateTime releaseDate;

    private String title;

    public Movie toEntity(){
        return Movie.builder()
                .genres(genres)
                .overview(overview)
                .rateAverage(rateAverage)
                .releaseDate(LocalDateTime.now())
                .title(title)
                .build();
    }

}
