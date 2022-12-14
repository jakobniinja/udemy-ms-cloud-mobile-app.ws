package com.jakobniinja.mobileappws.ui.controller;

import com.jakobniinja.mobileappws.ui.exceptions.UserServiceException;
import com.jakobniinja.mobileappws.ui.response.UserRest;
import com.jakobniinja.mobileappws.ui.request.UpdateUserDetailsModel;
import com.jakobniinja.mobileappws.ui.request.UserDetailsRequestModel;
import com.jakobniinja.mobileappws.ui.userservice.UserService;
import com.jakobniinja.mobileappws.ui.userservice.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;
    @Autowired
    UserService userService;

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

        if (true) {
            throw new UserServiceException("a user service exception is thrown");

        }

        if (users.containsKey(userId)) {
            return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest userRest = userService.createUser(userDetails);
        return new ResponseEntity<UserRest>(userRest, HttpStatus.CREATED);

    }

    @PutMapping(
            path = "/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}

    )
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsModel userDetails) {
        UserRest storedUserDetails = users.get(userId);
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = ("/{userId}"))
    public ResponseEntity deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }


}
