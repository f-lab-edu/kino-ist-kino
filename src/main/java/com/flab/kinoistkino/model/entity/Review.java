package com.flab.kinoistkino.model.entity;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"user","movie"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    // N : 1
    @ManyToOne
    private User user; // Hibernate를 통한 연관관계 설정을 할 때는 반드시 객체이름으로 맵핑한다 (알아서 user_id를 찾아간다)

    // N : 1
    @ManyToOne
    private Movie movie;

    private String name;

    private String content;

    private Float rate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Builder
    public Review(String name, String content, Float rate, LocalDateTime createdAt, LocalDateTime updatedAt) {
        Assert.notNull(name, "name must not be null");
        Assert.notNull(content, "content must not be null");
        Assert.notNull(String.valueOf(rate), "rate must not be null");
        Assert.hasText(String.valueOf(createdAt), "name must not be empty");
        Assert.hasText(String.valueOf(updatedAt), "name must not be empty");

        this.name = name;
        this.content = content;
        this.rate = rate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
