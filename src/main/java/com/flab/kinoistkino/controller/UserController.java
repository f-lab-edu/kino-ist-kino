package com.flab.kinoistkino.controller;

import com.flab.kinoistkino.exception.ResourceNotFoundException;
import com.flab.kinoistkino.model.User;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // 전체 user 리스트 가져오기
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // POST Mapping을 사용해서 유저 생성 (account, password, name, email) 순서로 입력
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // GetMapping name과 email 입력시 account 찾기
    @GetMapping("{name}/{email}")
    public ResponseEntity<String> getUserAccountByNameAndEmail(@PathVariable String name, @PathVariable String email) {
        User user = userRepository.findByNameAndEmail(name, email);
        return ResponseEntity.ok(user.getAccount());
    }
    // GetMapping name과 email, account 입력시 password 찾기
    @GetMapping("{name}/{email}/{account}")
    public ResponseEntity<String> getUserPasswordByNameAndEmailAndaccount(@PathVariable String name, @PathVariable String email, @PathVariable String account) {
        User user = userRepository.findByNameAndEmailAndAccount(name, email, account);
        return ResponseEntity.ok(user.getPassword());
    }

    // DeleteMapping name, email, account, pssword 입력시 삭제하는 기능
    @DeleteMapping("{name}/{email}/{account}/{password}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String name, @PathVariable String email, @PathVariable String account, @PathVariable String password ) {
        User user = userRepository.findByNameAndEmailAndAccountAndPassword(name, email, account, password);

        userRepository.delete(user);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
