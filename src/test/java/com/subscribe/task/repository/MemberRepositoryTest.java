package com.subscribe.task.repository;

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
public class MemberRepositoryTest {
     @Autowired
     MemberRepository memberRepository;

     @Test
     @Transactional
     @DisplayName("회원 저장")
     public void saveTest(){
          SaveDTO saveDTO = SaveDTO.builder()
                  .loginId("asd")
                  .password("123")
                  .name("rmsoft")
                  .email("rmsoft@naver.com")
                  .phoneNumber("010-1234-1234")
                  .address("서울시 강남구 역삼동")
                  .build();

          memberRepository.save(saveDTO);

          List<FindMemberDTO> memberList = memberRepository.findAll();

          assertEquals(1, memberList.size());
     }

     @Test
     @Transactional
     @DisplayName("회원 정보 조회")
     public void findById(){
          String id = "asd";
          String password = memberRepository.findPasswordByLoginId(id);

          assertEquals("123", password);
     }
}
