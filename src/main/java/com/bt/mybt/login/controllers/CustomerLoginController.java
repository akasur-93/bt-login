package com.bt.mybt.login.controllers;

import com.bt.mybt.login.dto.LoginDto;
import com.bt.mybt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerLoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/api/v1/login")
    public Boolean login(@RequestBody  LoginDto loginDto) {
        return loginService.login(loginDto.getUsername(), loginDto.getPassword());

    }

}
