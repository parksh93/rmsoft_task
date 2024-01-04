package com.subscribe.task.controller;

import com.subscribe.task.dto.user.FindUserDTO;
import com.subscribe.task.dto.user.SaveUserDTO;
import com.subscribe.task.dto.user.SignInDTO;
import com.subscribe.task.service.user.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    private UserService userService;
    public static final String ACCESS_TOKEN_COOKIE_NAME = "access_token";

    @Autowired
    public userController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<FindUserDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("/signup")
    public void signup(@RequestBody SaveUserDTO saveUserDTO){
        userService.save(saveUserDTO);
    }

    @GetMapping("/signIn")
    public void signIn(@RequestBody SignInDTO signInDTO, HttpServletResponse response){
        String token = userService.generateToken(signInDTO);

        Cookie cookie = new Cookie(ACCESS_TOKEN_COOKIE_NAME, token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");

        response.addCookie(cookie);
    }
}
