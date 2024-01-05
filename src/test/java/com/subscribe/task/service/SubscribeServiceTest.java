package com.subscribe.task.service;

import com.subscribe.task.dto.subscribe.FindSubDTO;
import com.subscribe.task.dto.subscribe.RequestExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.dto.subscribe.ResponseFindSubDTO;
import com.subscribe.task.service.subscribe.SubscribeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class SubscribeServiceTest {
    @Autowired
    SubscribeService subscribeService;

    @Test
    @Transactional
    @DisplayName("구독 정보 저장")
    public void saveSubTest(){
        RequestSaveSubDTO saveSubDTO = RequestSaveSubDTO.builder()
                .userId(1L)
                .personnel(2)
                .service("Basic")
                .storage(1L)
                .personnel(1)
                .amount(10000)
                .build();

        subscribeService.saveSub(saveSubDTO);

        List<FindSubDTO> subList = subscribeService.findAllSub();

        assertEquals(2, subList.size());
    }

    @Test
    @Transactional
    @DisplayName("사용자 서비스 이용현황 조회")
    public void findSubTest(){
        long memberId = 1L;

        ResponseFindSubDTO sub = subscribeService.findSub(memberId);

        assertNotNull(sub);
        assertEquals("Basic", sub.getService());
        assertEquals(31, sub.getRemainDate());
    }

    @Test
    @Transactional
    @DisplayName("서비스 이용기간 연장")
    public void updateSubRemainDateTest() {
        RequestExtensionPeriodDTO requestExtensionPeriodDTO = RequestExtensionPeriodDTO.builder()
                .id(1L)
                .period(1)
                .build();

        subscribeService.updateSubRemainDate(requestExtensionPeriodDTO);

        ResponseFindSubDTO subDTO = subscribeService.findSub(1L);

        assertEquals(LocalDate.now().plusMonths(1), subDTO.getEndDate());
    }
}
