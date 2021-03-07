package com.bt.mybt.login.repo;

import com.bt.mybt.login.entity.TimestampEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimestampRepo extends JpaRepository<TimestampEntity, Integer> {

}
