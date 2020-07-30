package com.citi.bank.entity;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Auth implements Serializable {

    private static final long serialVersionUID = 3934125099175748969L;

    @Id
    @Column
    private String id;

    @Column
    private String password;

    public Auth(String id, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        this.id = id;
        this.password = bCryptPasswordEncoder.encode(password);
    }

    public Auth(){

    }
}
