package com.subscribe.task.service.user;

import com.subscribe.task.dto.user.FindMemberDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;

import java.util.List;

public interface MemberService {
    List<FindMemberDTO> findAll();
    void save(SaveUserDTO saveUserDTO);
    FindMemberDTO findUser(SignInDTO signInDTO);
}
