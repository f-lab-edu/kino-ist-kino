package com.flab.kinoistkino.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Accessors(chain = true)
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

    private LocalDateTime updatedAt;

    @Builder
    public User(String account, String password, String name, String email, String phoneNumber, LocalDateTime createdAt,  LocalDateTime updatedAt) {
        Assert.notNull(account, "account must not be null");
        Assert.notNull(password, "password must not be null");
        Assert.notNull(name, "name must not be null");
        Assert.notNull(email, "email must not be null");
        Assert.notNull(phoneNumber, "phoneNumber must not be null");
        Assert.hasText(String.valueOf(createdAt), "createdAt must not be empty");
        Assert.hasText(String.valueOf(updatedAt), "updatedAt must not be empty");

        this.account = account;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // 1 : N
    @OneToMany(fetch = FetchType.LAZY , mappedBy = "user", orphanRemoval = true) // Review에 있는 user에 맵핑 시키겠다.
    // orphanRemoval=true로 설정해서, 외래키와 상관없이 삭제할 수 있도록했다.
    private List<Review> reviewList;

}
