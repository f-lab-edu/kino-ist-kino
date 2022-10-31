package com.flab.kinoistkino.service;

import com.flab.kinoistkino.ifs.CrudInterface;
import com.flab.kinoistkino.model.entity.User;
import com.flab.kinoistkino.model.network.Header;
import com.flab.kinoistkino.model.network.request.UserApiRequest;
import com.flab.kinoistkino.model.network.response.UserApiResponse;
import com.flab.kinoistkino.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements CrudInterface<UserApiRequest , UserApiResponse> {
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

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        // 1. request data
        UserApiRequest userApiRequest = request.getData();

        // 2. User 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .name(userApiRequest.getName())
                .email(userApiRequest.getEmail())
                .phoneNumber(userApiRequest.getPhoneNumber())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        // 3. 생성 된 데이터 기준으로 userApiResponse return


        return response(newUser);
    }

    @Override
    public Header<UserApiResponse> read(Long id) {

        return userRepository.findById(id)
                .map(user -> response(user))
                .orElseGet(
                        ()->Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {

/*        // 1. user 찾기
        UserApiRequest body = request.getData();

        userRepository.findById(body.getId())
                .map(entityUser -> {
                    entityUser.

                })
                .orElseGet()->Header.ERROR("데이터 없음");*/

        Optional<User> byId = userRepository.findById(request.getData().getId());
        byId.ifPresent(user ->{
            userRepository.save(request.getData().toEntity());
        });
       /* .orElseGet()-> Header.ERROR("데이터 없음");*/

        return Header.OK();
    }

    @Override
    public Header delete(Long id) {

        return null;
    }

    private Header<UserApiResponse> response(User user){
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();

        // Header + data return
        return Header.OK(userApiResponse);

    }
}
