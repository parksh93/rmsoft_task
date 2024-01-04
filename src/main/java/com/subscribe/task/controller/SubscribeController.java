package com.subscribe.task.controller;

import com.subscribe.task.dto.subscribe.FindSubDTO;
import com.subscribe.task.dto.subscribe.RequestExtensionPeriodDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.dto.subscribe.ResponseFindSubDTO;
import com.subscribe.task.service.subscribe.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub")
public class SubscribeController {
    SubscribeService subscribeService;

    @Autowired
    public SubscribeController(SubscribeService subscribeService){
        this.subscribeService = subscribeService;
    }

    @GetMapping("/findAllSub")
    public ResponseEntity<List<FindSubDTO>> findAllSub(){
        return ResponseEntity.ok(subscribeService.findAllSub());
    }

    @PostMapping("/subscription")
    public void subscription(@RequestBody RequestSaveSubDTO requestSaveSubDTO){
        subscribeService.saveSub(requestSaveSubDTO);
    }

    @GetMapping("/findSub/{memberId}")
    public ResponseEntity<ResponseFindSubDTO> findSub(@PathVariable long memberId){
        return ResponseEntity.ok(subscribeService.findSub(memberId));
    }

    @PatchMapping("/extensionPeriod")
    public void extensionPeriod(@RequestBody RequestExtensionPeriodDTO requestExtensionPeriodDTO){
        subscribeService.updateSubRemainDate(requestExtensionPeriodDTO);
    }
}
