package com.subscribe.task.service;

import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    @Transactional
    @DisplayName("회원 정보 추가")
    public void saveTest(){
        SaveUserDTO saveUserDTO = SaveUserDTO.builder()
                .loginId("asd1")
                .password("123")
                .name("rmsoft")
                .email("rmsoft@naver.com")
                .phoneNumber("010-1234-1234")
                .address("서울시 강남구 역삼동")
                .build();

        userService.save(saveUserDTO);

        List<FindUserDTO> userList = userService.findAll();

        assertEquals(2, userList.size());
        assertEquals("asd1", userList.get(1).getLoginId());
    }

    @Test
    @Transactional
    @DisplayName("로그인시 액세스 토큰 발급")
    public void findUser(){
        String loginId = "asd";
        String password = "123";

        SignInDTO signInDTO = SignInDTO.builder()
                .loginId(loginId)
                .password(password)
                .build();

        String token = userService.generateToken(signInDTO);

        assertNotEquals("", token);
    }
}
