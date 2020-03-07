package com.zk.repo;


import com.zk.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// for simulation..... you can use jpa
@Repository
public class UserRepo {
	static Map<Integer,User> users = new HashMap<>();
	static Integer maxId = 0;
	public UserRepo( ) {
		users.put(1, new User().setName("bob").setId(1));
		users.put(2, new User().setName("zk").setId(2));
		maxId = users.size();
	}

	public User getOne(int id){
		return users.get(id);
	}

	public User createUser(User user){
		maxId++;
		user.setId(maxId);
		users.put(maxId, user);
		return user;
	}
}
