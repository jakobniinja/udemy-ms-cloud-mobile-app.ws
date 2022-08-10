package com.jakobniinja.mobileappws.ui.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRest {

    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
