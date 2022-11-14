package com.zk.controller;

import com.zk.App;
import com.zk.api.RabbitAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RabbitControllerTest {

	@Autowired
	TestRestTemplate rest;

	@Test
	void hello() {
		RabbitAPI.Req req = new RabbitAPI.Req();
		req.setName("zk");
		req.setAge("12");

		ResponseEntity<String> forEntity = rest.postForEntity("/demo/feign",req, String.class);
		String body = forEntity.getBody();
		Assertions.assertEquals("zk12", body);
	}
}
