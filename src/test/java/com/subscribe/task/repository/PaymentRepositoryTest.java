package com.subscribe.task.repository;

import com.subscribe.task.dto.payment.FIndPaymentDTO;
import com.subscribe.task.dto.payment.SavePaymentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentRepositoryTest {
    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    @Transactional
    @DisplayName("결제 정보 저장")
    public void savePaymentTest(){
        SavePaymentDTO savePaymentDTO = SavePaymentDTO.builder()
                .userId(1)
                .amount(10000)
                .build();

        paymentRepository.savePayment(savePaymentDTO);

        List<FIndPaymentDTO> paymentList = paymentRepository.findAllPayment();

        assertEquals(1, paymentList.size());
        assertEquals(1, paymentList.get(0).getUserId());
    }
}
