package com.flab.kinoistkino.repository;


import com.flab.kinoistkino.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where account = ? << Test01, Test02
    Optional<User> findByAccount(String account); // 들어오는 account 명으로 검색 가능

    // JPA에서는 findBy까지 보고 select문인 것을 확인한다. 그 다음오는 대문자와 매개변수를 매칭 시킨다.
    Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ?
    Optional<User> findByAccountAndEmail(String account,String email);
}
