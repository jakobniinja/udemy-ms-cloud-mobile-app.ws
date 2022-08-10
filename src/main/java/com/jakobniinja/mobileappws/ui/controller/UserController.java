package com.jakobniinja.mobileappws.ui.controller;

import com.jakobniinja.mobileappws.ui.model.UserRest;
import com.jakobniinja.mobileappws.ui.request.UserDetailsRequestModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "50") int limit,
                          @RequestParam(value = "sort", required = false, defaultValue = "desc") String sort
    ) {
        return "get user was called page:" + page + ", limit: " + limit + " & sort " + sort;
    }

    @GetMapping(path = "/{userId}", produces = {
            MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest userRest = new UserRest();
        userRest.setEmail("test@test.com");
        userRest.setFirstName("jakob");
        userRest.setLastName("yaro");
        userRest.setUserId(userId);
        return new ResponseEntity<UserRest>(userRest, HttpStatus.BAD_REQUEST);
    }


    @PostMapping(
            consumes= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest userRest = new UserRest();
        userRest.setEmail(userDetails.getEmail());
        userRest.setFirstName(userDetails.getFirstName());
        userRest.setLastName(userDetails.getLastName());
        return new ResponseEntity<UserRest>(userRest, HttpStatus.SEE_OTHER);
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
