package com.flab.kinoistkino.service;

import com.flab.kinoistkino.model.entity.User;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        public void deleteUser(String account, Map<String, String> password){

            if(account == null || password ==null) {
                throw new NullPointerException("아이디나 패스워드가 입력되지 않았습니다.");
            }
            boolean exists = userRepository.existsByAccount(account);
            if(!exists) {
                throw new IllegalStateException("no account");
            }
            User user = userRepository.findByAccount(account).get();
            if(!(user.getPassword().equals ( password.get("password")))) {
                throw new IllegalStateException("password not correct");
            }
            userRepository.deleteByAccount(account);

        }

    }

