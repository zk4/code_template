package com.zk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zk.entity.User;
import com.zk.result.Result;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
public class RedisControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    ObjectMapper objectMapper;

    public RedisControllerTest() {
        objectMapper=new ObjectMapper();
    }

    @Before
    public void setUp() throws Exception {

        User user  = new User();
        user.setId(1);
        user.setName("zk");
        restTemplate.postForEntity("/redis/set",user, Result.class);
    }

    @After
    public void tearDown() throws Exception {
        Result<Boolean> userResult= Result.success(true);

        ResponseEntity<Result> response = restTemplate.getForEntity("/redis/delete/1", Result.class);
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }

    @Test
    public void redisGet() throws JsonProcessingException {
        // given
        User user = new User().setName("zk").setId(1);
        Result<User> userResult= Result.success(user);

        // when
        ResponseEntity<Result> response = restTemplate.getForEntity("/redis/get/1", Result.class);


        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }
    @Test
    public void redisExist() throws JsonProcessingException {
        // given

        Result<Boolean> userResult= Result.success(true);

        // when

        ResponseEntity<Result> response = restTemplate.getForEntity("/redis/exist/1", Result.class);



        // then
        Assert.assertEquals(HttpStatus.OK,response.getStatusCode()  );
        Assert.assertEquals(
                objectMapper.writeValueAsString(userResult),
                objectMapper.writeValueAsString(response.getBody())

        );
    }

}