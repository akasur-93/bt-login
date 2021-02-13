package com.bt.mybt.login.repo;

import com.bt.mybt.login.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Integer> {
    public LoginEntity findByUsername( String username);
}
