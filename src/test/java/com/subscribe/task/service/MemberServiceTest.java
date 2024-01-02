package com.subscribe.task.service;

import com.subscribe.task.dto.FindMemberDTO;
import com.subscribe.task.dto.SaveDTO;
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
        SaveDTO saveDTO = SaveDTO.builder()
                .loginId("asd")
                .password("123")
                .name("rmsoft")
                .email("rmsoft@naver.com")
                .phoneNumber("010-1234-1234")
                .address("서울시 강남구 역삼동")
                .build();

        memberService.save(saveDTO);

        List<FindMemberDTO> memberList = memberService.findAll();

        assertEquals(1, memberList.size());
    }
}
