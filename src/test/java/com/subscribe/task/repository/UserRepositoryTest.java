package com.subscribe.task.repository;

import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
     @Autowired
     UserRepository userRepository;

     @Test
     @Transactional
     @DisplayName("회원 저장")
     public void saveTest(){
          SaveUserDTO saveUserDTO = SaveUserDTO.builder()
                  .loginId("asd1")
                  .password("123")
                  .name("rmsoft")
                  .email("rmsoft@naver.com")
                  .phoneNumber("010-1234-1234")
                  .address("서울시 강남구 역삼동")
                  .build();

          userRepository.save(saveUserDTO);

          List<FindUserDTO> userList = userRepository.findAll();

          assertEquals(2, userList.size());
          assertEquals("asd1", userList.get(1).getLoginId());
     }

     @Test
     @Transactional
     @DisplayName("회원 정보 조회")
     public void findByLoginIdTest(){
          String loginId = "asd";
          FindUserDTO findUserDTO = userRepository.findByLoginId(loginId);

          assertEquals("123", findUserDTO.getPassword());
     }
}
