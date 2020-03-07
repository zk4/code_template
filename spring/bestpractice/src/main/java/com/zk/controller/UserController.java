package com.zk.controller;

import com.zk.entity.User;
import com.zk.result.Result;
import com.zk.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public Result<User> getUser(@PathVariable int id, User user){
        Result<User> success = Result.success(userService.getUser(id));
        return success;
    }

    @PostMapping("/user")
    public Result<User> createUser(@RequestBody User user){
        Result<User> success = Result.success(userService.createUser(user));
        return success;
    }

}
