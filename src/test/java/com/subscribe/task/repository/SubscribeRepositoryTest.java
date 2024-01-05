package com.subscribe.task.repository;

import com.subscribe.task.dto.subscribe.ExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.FindSubDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubscribeRepositoryTest {
    @Autowired
    private SubscribeRepository subscribeRepository;

    @Test
    @Transactional
    @DisplayName("사용자가 선택한 서비스 저장")
    public void saveSubTest(){
        SaveSubDTO saveSubDTO = SaveSubDTO.builder()
                .userId(1L)
                .personnel(2)
                .service("Basic")
                .storage(1L)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(1))
                .build();

        subscribeRepository.saveSub(saveSubDTO);

        List<FindSubDTO> subList = subscribeRepository.findAllSub();

        assertEquals(2, subList.size());
    }

    @Test
    @Transactional
    @DisplayName("사용자 서비스 사용현황 조회")
    public void findSubByMemberIdTest(){
        long userId = 1L;
        FindSubDTO sub = subscribeRepository.findSubByUserId(userId);

        assertNotNull(sub);
        assertEquals("Basic", sub.getService());
    }

    @Test
    @Transactional
    @DisplayName("서비스 기간 수정")
    public void updateSubRemainDateTest(){
        ExtensionPeriodDTO extensionPeriodDTO = ExtensionPeriodDTO.builder()
                .id(1)
                .endDate(LocalDate.now().plusMonths(1))
                .build();

        subscribeRepository.updateSubRemainDate(extensionPeriodDTO);

        FindSubDTO subDTO = subscribeRepository.findSubByUserId(1);

        assertEquals(LocalDate.now().plusMonths(1), subDTO.getEndDate());
    }
}
