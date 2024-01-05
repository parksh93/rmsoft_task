package com.subscribe.task.service.subscribe;

import com.subscribe.task.dto.subscribe.FindSubDTO;
import com.subscribe.task.dto.subscribe.RequestExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.dto.subscribe.ResponseFindSubDTO;

import java.util.List;

public interface SubscribeService {
    List<FindSubDTO> findAllSub();
    void saveSub(RequestSaveSubDTO requestSaveSubDTO);
    ResponseFindSubDTO findSub(long userId);
    void updateSubRemainDate(RequestExtensionPeriodDTO requestExtensionPeriodDTO);
}
