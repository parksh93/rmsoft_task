package com.subscribe.task.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FindUserDTO {
    private long id;
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
