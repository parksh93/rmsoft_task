package com.subscribe.task.service;

import com.subscribe.task.dto.user.FindMemberDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.service.user.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

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

        memberService.save(saveUserDTO);

        List<FindMemberDTO> memberList = memberService.findAll();

        assertEquals(2, memberList.size());
        assertEquals("asd1", memberList.get(1).getLoginId());
    }

    @Test
    @Transactional
    @DisplayName("사용자 조회")
    public void findUser(){
        String loginId = "asd";
        String password = "123";

        SignInDTO signInDTO = SignInDTO.builder()
                .loginId(loginId)
                .password(password)
                .build();

        FindMemberDTO findMemberDTO = memberService.findUser(signInDTO);

        assertEquals("rmsoft", findMemberDTO.getName());
    }
}
