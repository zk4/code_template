package com.zk.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zk.result.CodeMsg;
import com.zk.result.Result;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExceptionAdviceTest {

    @Autowired
    TestRestTemplate restTemplate;

    ObjectMapper objectMapper;
    public ExceptionAdviceTest() {
        objectMapper=new ObjectMapper();
    }

    @Test
    public void exceptionHandler() throws JsonProcessingException {
        Result<Object> error = Result.error(CodeMsg.REQUEST_ILLEGAL);

        ResponseEntity<Result> forEntity = restTemplate.getForEntity("/doestnot_exist_path", Result.class);

        Assert.assertEquals(objectMapper.writeValueAsString(error),objectMapper.writeValueAsString(forEntity.getBody())  );
    }
}