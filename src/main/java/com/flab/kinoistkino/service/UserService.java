package com.flab.kinoistkino.service;

import com.flab.kinoistkino.model.entity.User;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

        public void deleteUser(String account, String password){

            boolean exists = userRepository.existsByAccount(account);
            if(!exists) {
                throw new IllegalStateException("no account");
            }
            
            // ACCOUNT에 있는 Password를 찾는게 잘 안됨
            boolean wrongPassword = userRepository.existsByAccountAndPassword(account, password);
            if(!wrongPassword) {
                throw new IllegalStateException("wrong password");
            }

            userRepository.deleteByAccount(account);
        }

    }

