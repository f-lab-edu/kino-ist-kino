package com.flab.kinoistkino.model.network.request;

import com.flab.kinoistkino.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserApiRequest {

    private Long id;

    private String account;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public User toEntity(){
        return User.builder()
                .account(account)
                .createdAt(LocalDateTime.now())
                .password(password)
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .updatedAt(LocalDateTime.now())
                .build();
    }


}
