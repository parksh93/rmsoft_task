package com.subscribe.task.repository;

import com.subscribe.task.dto.payment.FIndPaymentDTO;
import com.subscribe.task.dto.payment.SavePaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentRepository {
    List<FIndPaymentDTO> findAllPayment();
    void savePayment(SavePaymentDTO savePaymentDTO);
}
