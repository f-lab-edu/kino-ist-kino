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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user", orphanRemoval = true) // Review에 있는 user에 맵핑 시키겠다.
    // orphanRemoval=true로 설정해서, 외래키와 상관없이 삭제할 수 있도록했다.
    private List<Review> reviewList;

}
