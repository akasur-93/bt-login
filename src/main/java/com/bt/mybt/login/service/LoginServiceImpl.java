package com.bt.mybt.login.service;

import com.bt.mybt.login.entity.LoginEntity;
import com.bt.mybt.login.exceptions.BadCredentialsException;
import com.bt.mybt.login.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;

    @Override
    public Boolean login(String username, String password) {
        LoginEntity loginEntity = loginRepo.findByUsername(username);

        if(loginEntity.getPassword().equals(password))
            return true;
        throw new BadCredentialsException("username or password is incorrect");
    }
}
