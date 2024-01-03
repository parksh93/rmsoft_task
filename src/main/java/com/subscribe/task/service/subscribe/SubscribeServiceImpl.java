package com.subscribe.task.service.subscribe;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.dto.subscribe.SaveSubDTO;
import com.subscribe.task.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService{
    SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository){
        this.subscribeRepository = subscribeRepository;
    }

    @Override
    public List<FindAllSubDTO> findAllSub() {
        return subscribeRepository.findAllSub();
    }

    @Override
    public void saveSub(RequestSaveSubDTO requestSaveSubDTO) {
        SaveSubDTO saveSubDTO = SaveSubDTO.builder()
                .memberId(requestSaveSubDTO.getMemberId())
                .personnel(requestSaveSubDTO.getPersonnel())
                .service(requestSaveSubDTO.getService())
                .storage(requestSaveSubDTO.getStorage())
                .startDate(LocalDateTime.now())
                .endDate(LocalDateTime.now().plusMonths(requestSaveSubDTO.getPeriod()))
                .build();

        subscribeRepository.saveSub(saveSubDTO);
    }
}
