package com.subscribe.task.service.subscribe;

import com.subscribe.task.dto.payment.SavePaymentDTO;
import com.subscribe.task.dto.subscribe.*;
import com.subscribe.task.exception.NotMatchAmountException;
import com.subscribe.task.repository.PaymentRepository;
import com.subscribe.task.repository.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService{
    private final SubscribeRepository subscribeRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository, PaymentRepository paymentRepository){
        this.subscribeRepository = subscribeRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<FindSubDTO> findAllSub() {
        return subscribeRepository.findAllSub();
    }

    @Override
    @Transactional
    public void saveSub(RequestSaveSubDTO requestSaveSubDTO) {
        boolean checkAmount = compareAmount(requestSaveSubDTO.getAmount(),
                                            requestSaveSubDTO.getPeriod(),
                                            requestSaveSubDTO.getService(),
                                            requestSaveSubDTO.getUserId());

        if(checkAmount){
            SaveSubDTO saveSubDTO = SaveSubDTO.builder()
                    .userId(requestSaveSubDTO.getUserId())
                    .personnel(requestSaveSubDTO.getPersonnel())
                    .service(requestSaveSubDTO.getService())
                    .storage(requestSaveSubDTO.getStorage())
                    .startDate(LocalDate.now())
                    .endDate(LocalDate.now().plusMonths(requestSaveSubDTO.getPeriod()))
                    .build();

            subscribeRepository.saveSub(saveSubDTO);
        }
    }

    @Override
    public ResponseFindSubDTO findSub(long memberId) {
        FindSubDTO subDTO = subscribeRepository.findSubByUserId(memberId);

        long remainDate = ChronoUnit.DAYS.between(subDTO.getStartDate(), subDTO.getEndDate());

        ResponseFindSubDTO responseSubDTO = ResponseFindSubDTO.builder()
                        .id(subDTO.getId())
                        .userId(subDTO.getUserId())
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
    @Transactional
    public void updateSubRemainDate(RequestExtensionPeriodDTO requestExtensionPeriodDTO) {
        int period = requestExtensionPeriodDTO.getPeriod();
        FindSubDTO subInfo = subscribeRepository.findSubById(requestExtensionPeriodDTO.getId());
        String service = subInfo.getService();
        long userId = subInfo.getUserId();
        boolean checkAmount = compareAmount(requestExtensionPeriodDTO.getAmount(), period, service, userId);

        if (checkAmount){
            LocalDate endDate = LocalDate.now().plusMonths(period);

            ExtensionPeriodDTO extensionPeriodDTO = ExtensionPeriodDTO.builder()
                    .id(requestExtensionPeriodDTO.getId())
                    .endDate(endDate)
                    .build();

            subscribeRepository.updateSubRemainDate(extensionPeriodDTO);
        }
    }

    @Transactional
    public boolean compareAmount(long requestAmount, int period, String service, long userId){
        long amount = switch (service) {
            case "Basic" -> (long) 10000 * period;
            case "Standard" -> (long) 25000 * period;
            case "Premium" -> (long) 50000 * period;
            default -> 0;
        };

        if (amount == requestAmount){
            SavePaymentDTO savePaymentDTO = SavePaymentDTO.builder()
                    .userId(userId)
                    .amount(amount)
                    .build();
            paymentRepository.savePayment(savePaymentDTO);

            return true;
        }else {
            throw new NotMatchAmountException("not match amount");
        }
    }
}
