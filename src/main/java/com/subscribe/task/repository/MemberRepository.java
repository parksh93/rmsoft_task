package com.subscribe.task.repository;

import com.subscribe.task.dto.FindMemberDTO;
import com.subscribe.task.dto.SaveDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberRepository {
    List<FindMemberDTO> findAll();
    void save(SaveDTO saveDTO);
    String findPasswordByLoginId(String loginId);
}
