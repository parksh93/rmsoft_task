package com.subscribe.task.repository;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscribeRepository {
    List<FindAllSubDTO> findAllSub();
    void saveSub(SaveSubDTO saveSubDTO);
}
