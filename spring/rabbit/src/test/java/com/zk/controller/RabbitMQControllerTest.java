package com.zk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zk.result.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RabbitMQControllerTest {

    ObjectMapper objectMapper;

    @Autowired
    TestRestTemplate restTemplate;


    public RabbitMQControllerTest() {
        objectMapper=new ObjectMapper();
    }

    @Test
    public void header() throws JsonProcessingException {
        // given
        String value ="hello";
        Result<String> userResult= Result.success(value);

        // when
        ResponseEntity<Result> response = restTemplate.postForEntity("/mq/header",value, Result.class);


        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }

    @Test
    public void fanout() throws JsonProcessingException {
        // given
        String value ="hello";
        Result<String> userResult= Result.success(value);

        // when
        ResponseEntity<Result> response = restTemplate.postForEntity("/mq/fanout",value, Result.class);


        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }

    @Test
    public void topic() throws JsonProcessingException {
        // given
        String value ="hello";
        Result<String> userResult= Result.success(value);

        // when
        ResponseEntity<Result> response = restTemplate.postForEntity("/mq/topic",value, Result.class);


        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }

    @Test
    public void mq() throws JsonProcessingException {
        // given
        String value ="hello";
        Result<String> userResult= Result.success(value);

        // when
        ResponseEntity<Result> response = restTemplate.postForEntity("/mq",value, Result.class);


        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }
}