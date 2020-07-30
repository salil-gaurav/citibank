package com.citi.bank.entity;

import com.citi.bank.domain.UserDetails;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -2695615603273837211L;

    @Column
    private String key;

    @Id
    @Column
    private String email;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String ssn;

    public void setUser(UserDetails userDetails) {
        this.firstName = userDetails.getFirstName();
        this.lastName = userDetails.getLastName();
        this.address = userDetails.getAddress();
        this.phoneNumber = userDetails.getPhoneNumber();
        this.email = userDetails.getEmail();
        this.ssn = userDetails.getSsn();
    }

}
