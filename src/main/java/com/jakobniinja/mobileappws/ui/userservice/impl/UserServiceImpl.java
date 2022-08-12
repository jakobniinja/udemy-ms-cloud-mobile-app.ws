package com.jakobniinja.mobileappws.ui.userservice.impl;

import com.jakobniinja.mobileappws.ui.request.UserDetailsRequestModel;
import com.jakobniinja.mobileappws.ui.response.UserRest;
import com.jakobniinja.mobileappws.ui.shared.Utils;
import com.jakobniinja.mobileappws.ui.userservice.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;
    Utils utils;

    public UserServiceImpl() {}

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }



    public UserRest createUser(UserDetailsRequestModel userDetails) {


        UserRest userRest = new UserRest();
        String userId = utils.generateUserId();

        userRest.setEmail(userDetails.getEmail());
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        userRest.setUserId(userId);

        if (users == null) users = new HashMap<>();

        users.put(userId, userRest);

        return userRest;
    }
}
