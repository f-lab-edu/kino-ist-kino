package com.flab.kinoistkino.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieApiResponse {

    private Long id;

    private String genres;

    private String overview;

    private Float rateAverage;

    private LocalDateTime releaseDate;

    private String title;

}
