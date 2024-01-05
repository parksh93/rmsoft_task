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
public class FindSubDTO {
    private long id;
    private long userId;
    private int personnel;
    private String service;
    private long storage;
    private long storageUsage;
    private LocalDate startDate;
    private LocalDate endDate;
}
