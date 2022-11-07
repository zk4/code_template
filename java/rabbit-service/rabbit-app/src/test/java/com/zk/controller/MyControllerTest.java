package com.zk.controller;

import com.zk.App;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

@SpringBootTest(classes = App.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyControllerTest {

	@Autowired
	TestRestTemplate rest;

	@Test
	void hello() {
		HashMap<String, Integer> body = new HashMap<>();
		body.put("a", 2);
		body.put("b", 3);

		ResponseEntity<Integer> forEntity = rest.postForEntity("/count",body, Integer.class);
		Integer result = forEntity.getBody();
		Assertions.assertEquals(5, result);
	}
}
