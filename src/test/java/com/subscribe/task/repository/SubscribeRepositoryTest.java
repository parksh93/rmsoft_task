package com.subscribe.task.repository;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SubscribeRepositoryTest {
    @Autowired
    private SubscribeRepository subscribeRepository;

    @Test
    @Transactional
    @DisplayName("사용자가 선택한 서비스 저장")
    public void saveSubTest(){
        SaveSubDTO saveSubDTO = SaveSubDTO.builder()
                .memberId(1L)
                .personnel(2)
                .service("Basic")
                .storage(1L)
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusDays(31))
                .build();

        subscribeRepository.saveSub(saveSubDTO);

        List<FindAllSubDTO> subList = subscribeRepository.findAllSub();

        assertEquals(1, subList.size());
    }
}
