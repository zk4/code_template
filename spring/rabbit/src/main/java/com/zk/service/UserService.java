package com.zk.service;

import com.zk.entity.User;
import com.zk.exception.UserNotFound;
import com.zk.redis.RedisService;
import com.zk.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepo userRepo;
	RedisService redisService;

	@Autowired
	public UserService(UserRepo userRepo, RedisService redisService) {
		this.redisService = redisService;
		this.userRepo = userRepo;
	}

	public User getUser(int id) {
		User user = userRepo.getOne(id);
		if (user == null) {
			throw new UserNotFound();
		} else
			return user;
	}
}
