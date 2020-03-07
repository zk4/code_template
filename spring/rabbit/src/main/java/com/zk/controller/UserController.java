package com.zk.controller;

import com.zk.entity.User;
import com.zk.result.Result;
import com.zk.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
