package com.subscribe.task.service.subscribe;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;

import java.util.List;

public interface SubscribeService {
    List<FindAllSubDTO> findAllSub();

    void saveSub(RequestSaveSubDTO requestSaveSubDTO);
}
