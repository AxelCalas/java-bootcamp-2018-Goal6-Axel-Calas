package com.globant.bootcamp.controllers;

import com.globant.bootcamp.objects.User;
import com.globant.bootcamp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping (path = "/users/show")
    List<User> showAllUsers(){
        return userService.showAllUsers();
    }

    @GetMapping (path = "/users/show{user_id}")
    User showUser(@PathVariable Long user_id){
        return userService.showUser(user_id);
    }

    @PostMapping (path = "/users/new")
    User createUser(@RequestParam("name") String name, @RequestParam("password") String password){
        User user = new User(name, password);
        return userService.createUser(user);
    }

    @DeleteMapping (path = "/users/delete{user_id}")
    String deleteUser(@PathVariable Long user_id) {
        return userService.deleteUser(user_id);
    }
}

