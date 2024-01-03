package com.subscribe.task.controller;

import com.subscribe.task.dto.subscribe.FindAllSubDTO;
import com.subscribe.task.dto.subscribe.RequestSaveSubDTO;
import com.subscribe.task.service.subscribe.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<FindAllSubDTO> findAllSub(){
        return subscribeService.findAllSub();
    }

    @PostMapping("/subscription")
    public void subscription(@RequestBody RequestSaveSubDTO requestSaveSubDTO){
        subscribeService.saveSub(requestSaveSubDTO);
    }

}
