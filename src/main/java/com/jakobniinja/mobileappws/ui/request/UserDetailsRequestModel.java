package com.jakobniinja.mobileappws.ui.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetailsRequestModel {

    @NotEmpty(message = "firstName can't be empty")
    @Size(message = "firstName must be greater than 2 characters", min = 2)
    private String firstName;

    @NotEmpty(message = "lastName can't be empty")
    private String lastName;

    @NotEmpty(message = "email can't be empty")
    @Email()
    private String email;

    @NotEmpty(message = "password can't be empty")
    @Size(min = 8, message = "password must be greater than 7 characters")
    @Size(max = 16, message = "password must be less than 17 characters")

    private String password;

}
