package com.bt.mybt.login.entity;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "login")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class LoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column
    protected String username;

    @Column
    protected String password;
}
