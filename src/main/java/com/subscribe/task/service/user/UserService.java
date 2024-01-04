package com.subscribe.task.service.user;

import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface UserService {
    List<FindUserDTO> findAll();
    void save(SaveUserDTO saveUserDTO);
    String generateToken(SignInDTO signInDTO);
}
