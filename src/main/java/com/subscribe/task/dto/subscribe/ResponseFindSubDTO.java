package com.subscribe.task.dto.subscribe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ResponseFindSubDTO {
    private long id;
    private long memberId;
    private int personnel;
    private String service;
    private long storage;
    private long storageUsage;
    private long storageRemain;
    private LocalDate startDate;
    private LocalDate endDate;
    private long remainDate;
}
