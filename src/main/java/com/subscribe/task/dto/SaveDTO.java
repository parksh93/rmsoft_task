package com.subscribe.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SaveDTO {
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
