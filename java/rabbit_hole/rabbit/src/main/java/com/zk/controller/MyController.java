package com.zk.controller;

import com.zk.Hole;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {


	@PostMapping("/rabbitCount")
	public Integer hello(@RequestBody Req req){
		return new Hole().countRabbit(req.a,req.b);
	}

	static class Req {
		Integer a;
		Integer b;

		public Integer getA() {
			return a;
		}

		public Req setA(Integer a) {
			this.a = a;
			return this;
		}

		public Integer getB() {
			return b;
		}

		public Req setB(Integer b) {
			this.b = b;
			return this;
		}
	}
}
