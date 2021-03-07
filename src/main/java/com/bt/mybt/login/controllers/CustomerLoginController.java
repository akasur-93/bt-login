package com.bt.mybt.login.controllers;

import com.bt.mybt.login.dto.LoginDto;
import com.bt.mybt.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerLoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/api/v1/login", method = RequestMethod.GET)
    public Boolean login(@RequestBody  LoginDto loginDto) {
        return loginService.login(loginDto.getUsername(), loginDto.getPassword());
    }
}
