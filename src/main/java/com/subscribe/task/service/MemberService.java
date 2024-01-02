package com.subscribe.task.service;

import com.subscribe.task.dto.FindMemberDTO;
import com.subscribe.task.dto.SaveDTO;

import java.util.List;

public interface MemberService {
    List<FindMemberDTO> findAll();
    void save(SaveDTO saveDTO);
}
