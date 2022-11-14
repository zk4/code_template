package com.zk.controller;

import com.zk.api.RabbitAPI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController implements RabbitAPI {

    @Override
    public String demo(@RequestBody Req req) {
        return req.getName() + req.getAge();
    }
}