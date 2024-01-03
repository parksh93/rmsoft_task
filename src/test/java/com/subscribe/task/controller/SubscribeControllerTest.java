package com.subscribe.task.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
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
public class SubscribeControllerTest {
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
    @DisplayName("서비스 구독 신청")
    public void subscriptionTest() throws Exception {
        RequestSaveSubDTO saveSubDTO = RequestSaveSubDTO.builder()
                .memberId(1L)
                .personnel(2)
                .service("Basic")
                .storage(1L)
                .personnel(1)
                .build();
        String url = "/sub/subscription";
        String url2 = "/sub/findAllSub";

        final String request = objectMapper.writeValueAsString(saveSubDTO);

        mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON).content(request));

        final ResultActions result = mockMvc.perform(get(url2).accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].memberId").value(1));
    }
}
