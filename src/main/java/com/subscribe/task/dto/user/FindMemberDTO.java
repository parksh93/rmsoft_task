package com.subscribe.task.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FindMemberDTO {
    private long id;
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
}
