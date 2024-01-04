package com.subscribe.task.service.subscribe;

import com.subscribe.task.dto.subscribe.*;
import com.subscribe.task.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService{
    SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository){
        this.subscribeRepository = subscribeRepository;
    }

    @Override
    public List<FindSubDTO> findAllSub() {
        return subscribeRepository.findAllSub();
    }

    @Override
    public void saveSub(RequestSaveSubDTO requestSaveSubDTO) {
        SaveSubDTO saveSubDTO = SaveSubDTO.builder()
                .memberId(requestSaveSubDTO.getMemberId())
                .personnel(requestSaveSubDTO.getPersonnel())
                .service(requestSaveSubDTO.getService())
                .storage(requestSaveSubDTO.getStorage())
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusMonths(requestSaveSubDTO.getPeriod()))
                .build();

        subscribeRepository.saveSub(saveSubDTO);
    }

    @Override
    public ResponseFindSubDTO findSub(long memberId) {
        FindSubDTO subDTO = subscribeRepository.findSubByMemberId(memberId);

        long remainDate = ChronoUnit.DAYS.between(subDTO.getStartDate(), subDTO.getEndDate());

        ResponseFindSubDTO responseSubDTO = ResponseFindSubDTO.builder()
                        .id(subDTO.getId())
                        .memberId(subDTO.getMemberId())
                        .personnel(subDTO.getPersonnel())
                        .service(subDTO.getService())
                        .storage(subDTO.getStorage())
                        .storageUsage(subDTO.getStorageUsage())
                        .storageRemain(subDTO.getStorage() - subDTO.getStorageUsage())
                        .startDate(subDTO.getStartDate())
                        .endDate(subDTO.getEndDate())
                        .remainDate(remainDate)
                        .build();

        return responseSubDTO;
    }

    @Override
    public void updateSubRemainDate(RequestExtensionPeriodDTO requestExtensionPeriodDTO) {
        int period = requestExtensionPeriodDTO.getPeriod();
        LocalDate endDate = LocalDate.now().plusMonths(period);

        ExtensionPeriodDTO extensionPeriodDTO = ExtensionPeriodDTO.builder()
                .id(requestExtensionPeriodDTO.getId())
                .endDate(endDate)
                .build();

        subscribeRepository.updateSubRemainDate(extensionPeriodDTO);
    }
}
