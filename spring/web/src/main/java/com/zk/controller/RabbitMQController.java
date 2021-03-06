package com.zk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zk.rabbitmq.MQSender;
import com.zk.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RabbitMQController {

    private  MQSender sender;

    @Autowired
    public RabbitMQController(MQSender sender) {
        this.sender = sender;
    }

    @PostMapping("/mq/header")
    public Result<String> header(@RequestBody  String value) throws JsonProcessingException {
		sender.sendHeader(value);
        return Result.success(value);
    }

	@PostMapping("/mq/fanout")
    public Result<String> fanout(@RequestBody  String value) throws JsonProcessingException {
		sender.sendFanout(value);
        return Result.success(value);
    }

	@PostMapping("/mq/topic")
    public Result<String> topic(@RequestBody  String value) throws JsonProcessingException {
		sender.sendTopic(value);
        return Result.success(value);
    }

	@PostMapping("/mq")
    public Result<String> mq(@RequestBody  String value) throws JsonProcessingException {
		sender.send(value);
        return Result.success(value);
    }
}
