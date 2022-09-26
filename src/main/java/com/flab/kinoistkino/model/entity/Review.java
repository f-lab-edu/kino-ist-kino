package com.flab.kinoistkino.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
