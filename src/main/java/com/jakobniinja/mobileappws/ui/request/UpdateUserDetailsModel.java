package com.jakobniinja.mobileappws.ui.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UpdateUserDetailsModel {
    @NotEmpty(message = "firstName can't be empty")

    @Size(message = "firstName must be greater than 2 characters", min = 2)
    private String firstName;

    @NotEmpty(message = "lastName can't be empty")
    private String lastName;
}
