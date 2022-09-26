package com.flab.kinoistkino.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam { // 이 객체를 통해 파라미터 요청을 받는다.

    private String account;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private int page;

}
