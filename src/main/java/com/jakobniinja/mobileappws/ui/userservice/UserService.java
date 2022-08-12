package com.jakobniinja.mobileappws.ui.userservice;

import com.jakobniinja.mobileappws.ui.request.UserDetailsRequestModel;
import com.jakobniinja.mobileappws.ui.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetails);
}

