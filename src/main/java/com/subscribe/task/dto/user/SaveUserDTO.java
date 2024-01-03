package com.subscribe.task.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SaveUserDTO {
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
