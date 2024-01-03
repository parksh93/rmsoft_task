package com.subscribe.task.dto.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInDTO {
    private String loginId;
    private String password;
}
