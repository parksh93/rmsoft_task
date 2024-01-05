package com.subscribe.task.repository;

import com.subscribe.task.dto.subscribe.ExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.FindSubDTO;
import com.subscribe.task.dto.subscribe.RequestExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubscribeRepository {
    List<FindSubDTO> findAllSub();
    void saveSub(SaveSubDTO saveSubDTO);
    FindSubDTO findSubByUserId(long userId);
    FindSubDTO findSubById(long id);
    void updateSubRemainDate(ExtensionPeriodDTO extensionPeriodDTO);

}
