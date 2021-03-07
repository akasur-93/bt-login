package com.bt.mybt.login.entity;



import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "timestamp")
public class TimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;
    @Column
    private String locale;
    @Column
    private LocalDateTime date;
    @Column
    private String os;

    public String getOs() {
        return os;
    }

    public TimestampEntity setOs(String os) {
        this.os = os;
        return this;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public String getUsername() {
        return username;
    }

    public TimestampEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public TimestampEntity setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public TimestampEntity setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }
}
