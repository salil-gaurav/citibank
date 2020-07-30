package com.citi.bank.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class RegistrationDetails implements Serializable {

    private static final long serialVersionUID = 2930734048040533075L;

    @NotNull
    @Valid
    private UserDetails user;

    @NotEmpty(message = "Password cannot be empty")
    private String password;
}

