package com.subscribe.task.service;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.service.subscribe.SubscribeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubscribeServiceTest {
    @Autowired
    SubscribeService subscribeService;

    @Test
    @Transactional
    @DisplayName("구독 정보 저장")
    public void saveSubTest(){
        RequestSaveSubDTO saveSubDTO = RequestSaveSubDTO.builder()
                .memberId(1L)
                .personnel(2)
                .service("Basic")
                .storage(1L)
                .personnel(1)
                .build();

        subscribeService.saveSub(saveSubDTO);

        List<FindAllSubDTO> subList = subscribeService.findAllSub();

        assertEquals(1, subList.size());
    }
}
