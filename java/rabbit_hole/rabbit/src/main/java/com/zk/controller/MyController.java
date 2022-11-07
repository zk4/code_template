package com.zk.controller;

import com.zk.Hole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {



	@GetMapping("/rabbitCount")
	public Integer hello(){
		return new Hole().countRabbit();
	}
}
