package com.subscribe.task.dto.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RequestSaveSubDTO {
    private long memberId;
    private int personnel;
    private String service;
    private long storage;
    private int period;
}
