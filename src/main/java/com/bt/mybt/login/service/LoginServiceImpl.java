package com.bt.mybt.login.service;

import com.bt.mybt.login.entity.LoginEntity;
import com.bt.mybt.login.entity.TimestampEntity;
import com.bt.mybt.login.exceptions.BadCredentialsException;
import com.bt.mybt.login.repo.LoginRepo;
import com.bt.mybt.login.repo.TimestampRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepo loginRepo;
    @Autowired
    private TimestampRepo timestampRepo;

    @Override
    public Boolean login(String username, String password) {
        LoginEntity loginEntity = loginRepo.findByUsername(username);

        if (loginEntity.getPassword().equals(password)) {
            TimestampEntity timestamp = new TimestampEntity();
            timestamp = timestamp.setLocale(Locale.getDefault().toString()).setDate(LocalDateTime.now()).setUsername(username).setOs(System.getProperty("os.name"));
            timestampRepo.save(timestamp);
            return true;
        }
        throw new BadCredentialsException("username or password is incorrect");
    }
}
