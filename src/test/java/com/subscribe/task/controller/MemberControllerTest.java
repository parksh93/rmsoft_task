package com.subscribe.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public  void setMockMvc() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    @Transactional
    @DisplayName("회원 가입")
    public void signupTest() throws Exception {
        String url = "/user/signup";
        String url2 = "/user/findAll";

        SaveUserDTO saveUserDTO = SaveUserDTO.builder()
                .loginId("asd1")
                .password("123")
                .name("rmsoft")
                .email("rmsoft@naver.com")
                .phoneNumber("010-1234-1234")
                .address("서울시 강남구 역삼동")
                .build();

        final String request = objectMapper.writeValueAsString(saveUserDTO);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(request));

        final ResultActions result = mockMvc.perform(get(url2).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].loginId").value("asd"));
    }

    @Test
    @Transactional
    @DisplayName("로그인")
    public void signInTest() throws Exception{
        String url = "/user/signIn";

        SignInDTO signInDTO = SignInDTO.builder()
                .loginId("asd")
                .password("123")
                .build();

        final String request = objectMapper.writeValueAsString(signInDTO);

        final ResultActions result = mockMvc.perform(get(url).contentType(MediaType.APPLICATION_JSON).content(request));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("rmsoft"));
    }
}
