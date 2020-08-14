package com.zk.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zk.entity.User;
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

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

	ObjectMapper objectMapper;

	@Autowired
	TestRestTemplate restTemplate;


	public UserControllerTest() {
		objectMapper=new ObjectMapper();
	}


	@Test
	public void createUserWithBadPhone() throws IOException {
		Result<Boolean> excp = Result.error(CodeMsg.SERVER_ERROR);

		User user = new User().setName("goome").setPhonenumber("123");
		ResponseEntity<String>
				response = restTemplate.postForEntity("/user", user, String.class);
		Result<Boolean> resultObj = new ObjectMapper().readValue(response.getBody(),
				new TypeReference<Result<Boolean>>() {
				});
		Assert.assertEquals(objectMapper.writeValueAsString(excp),
				objectMapper.writeValueAsString(resultObj));
	}
	@Test
	public void createUserWithGoodPhone() throws IOException {
		User user = new User().setName("goome").setPhonenumber("15310111111");
		ResponseEntity<String>
				response = restTemplate.postForEntity("/user", user, String.class);
		Result<User> resultObj =new ObjectMapper().readValue(response.getBody(),new TypeReference<Result<User>>(){});

		Assert.assertEquals(user.getName(),
				resultObj.getData().getName() );

		Assert.assertNotNull(resultObj.getData().getId());
	}

}
