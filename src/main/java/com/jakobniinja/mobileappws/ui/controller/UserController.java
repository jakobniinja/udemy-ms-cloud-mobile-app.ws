package com.jakobniinja.mobileappws.ui.controller;

import com.jakobniinja.mobileappws.ui.modal.UserRest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort
    ) {
        return "get user was called page:" + page + ", limit: " + limit + " & sort " + sort;
    }

    @GetMapping(path = "/{userId}")
    public UserRest getUser(@PathVariable String userId) {
        UserRest userRest = new UserRest();
        userRest.setEmail("test@test.com");
        userRest.setFirstName("jakob");
        userRest.setLastName("yaro");
        userRest.setUserId(userId);
        return userRest;
    }


    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "put user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }


}
