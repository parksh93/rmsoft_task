package com.subscribe.task.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class FIndPaymentDTO {
    private long id;
    private long userId;
    private long amount;
    private LocalDate paymentDate;
}
