package com.bt.mybt.login.repo;

import com.bt.mybt.login.entity.LoginEntity;
import com.bt.mybt.login.entity.TimestampEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimestampRepo extends JpaRepository<TimestampEntity, Integer> {
    public List<TimestampEntity> findByUsername(String username);

}
