package com.citi.bank.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@JsonInclude(Include.NON_EMPTY)
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 3931125099175748969L;

    private String id;

    @NotEmpty(message = "Email is mandatory")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}", message = "Email is incorrect")
    private String email;

    @NotEmpty(message = "First name is mandatory")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    private String lastName;

    @NotEmpty(message = "Address is mandatory")
    private String address;

    @NotEmpty(message = "Phone number is mandatory")
    @Pattern(regexp = "^\\d{2}-\\d{3}-\\d{4}$", message = "Phone number is  not valid")
    private String phoneNumber;

    @NotEmpty(message = "SSN is mandatory")
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$", message = "SSN is invalid")
    private String ssn;
}
