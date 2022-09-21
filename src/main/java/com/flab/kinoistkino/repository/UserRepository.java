package com.flab.kinoistkino.repository;

import com.flab.kinoistkino.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameAndEmail(String name, String email);

    User findByNameAndEmailAndAccount(String name, String email, String account);
    User findByNameAndEmailAndAccountAndPassword(String name, String email, String account, String password);

}
