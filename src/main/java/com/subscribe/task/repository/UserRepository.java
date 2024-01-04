package com.subscribe.task.repository;

import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<FindUserDTO> findAll();
    void save(SaveUserDTO saveUserDTO);
    FindUserDTO findByLoginId(String loginId);
}
