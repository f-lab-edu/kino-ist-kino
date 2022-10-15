package com.flab.kinoistkino.repository;

import com.flab.kinoistkino.KinoIstKinoApplicationTests;
import com.flab.kinoistkino.model.entity.Movie;
import com.flab.kinoistkino.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends KinoIstKinoApplicationTests {

    @Autowired // Dependency Injection (DI) 의존성 주입
    private UserRepository userRepository;


    @Test
    public void create() {
// 다른 프레임워크 사용 시 보통 String sql = insert into user (%s, %s, %d) value (account, email, age); 처럼 사용
        User user = User.builder()
                .account("Test2")
                .password("11")
                .name("jun")
                .email("aaa@aaa.com")
                .phoneNumber("111-1111-1111")
                .build();

        User newUser = userRepository.save(user);
        System.out.println("newUser : "+newUser);
    }

    @Test
    @Transactional
    public void read(){
        // select * from user where id=?
        Optional<User> user = userRepository.findByAccount("TestUser01");

        user.ifPresent(selectUser -> {

            selectUser.getReviewList().stream().forEach(kinoreview -> {
                Movie movie = kinoreview.getMovie();
                System.out.println(kinoreview.getMovie());

            });
        });

    }

/*    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("Tester2");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser); // id를 지정했기 때문에 JPA가 신규가 아닌 update라고 인식한다.
        });
    }*/

    @Test
    @Transactional // 쿼리가 실행되더라도 롤백되서 DB 정보는 그대로 있다. (Test용)
    public void delete(){
        Optional<User> user = userRepository.findById(2L);

        Assertions.assertTrue(user.isPresent()); // 반드시 값이 있어야 하기 때문에 꼭 존재해야한다고 추가

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        Assertions.assertFalse(deleteUser.isPresent()); // 반드시 값이 없어야 하기 때문에 추가
        }
    }

