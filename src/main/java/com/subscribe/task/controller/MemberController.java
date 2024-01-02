package com.subscribe.task.controller;

import com.subscribe.task.dto.FindMemberDTO;
import com.subscribe.task.dto.SaveDTO;
import com.subscribe.task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class MemberController {
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FindMemberDTO>> findAll() {
        return ResponseEntity.ok(memberService.findAll());
    }


    @PostMapping("/signup")
    public void signup(@RequestBody SaveDTO saveDTO){
        memberService.save(saveDTO);
    }
}
