package com.subscribe.task.controller;

import com.subscribe.task.dto.user.FindMemberDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.service.user.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public void signup(@RequestBody SaveUserDTO saveUserDTO){
        memberService.save(saveUserDTO);
    }

    @GetMapping("/signIn")
    public ResponseEntity<?> signIn(@RequestBody SignInDTO signInDTO){
        return ResponseEntity.ok(memberService.findUser(signInDTO));
    }
}
