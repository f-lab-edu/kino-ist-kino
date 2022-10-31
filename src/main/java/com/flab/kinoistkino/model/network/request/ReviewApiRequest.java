package com.flab.kinoistkino.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewApiRequest {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private String name;

    private Float rate;

    private LocalDateTime updatedAt;

    private Long movieId;

    private Long userId;

}
