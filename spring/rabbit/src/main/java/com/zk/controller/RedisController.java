package com.zk.controller;

import com.zk.entity.User;
import com.zk.redis.RedisService;
import com.zk.redis.UserKey;
import com.zk.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/redis")
public class RedisController {


	
	@Autowired
    RedisService redisService;



    @RequestMapping("/get/{id}")
    @ResponseBody
    public Result<User> redisGet(@PathVariable Integer id) {
    	User  user  = redisService.get(UserKey.getById, ""+id, User.class);
        return Result.success(user);
    }
    
    @PostMapping("/set")
    @ResponseBody
    public Result<Boolean> redisSet(@RequestBody  User user) {
    	//User user  = new User();
    	//user.setId(1);
    	//user.setName("zk");
    	redisService.set(UserKey.getById, ""+user.getId(), user);//UserKey:id1
        return Result.success(true);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public Result<Boolean> redisDelete(@PathVariable Integer id) {
         return Result.success(redisService.delete(UserKey.getById, ""+id));
    }

    @RequestMapping("/exist/{id}")
    @ResponseBody
    public Result<Boolean> redisExist(@PathVariable Integer id) {
        Result<Boolean> success = Result.success(redisService.exists(UserKey.getById, "" + id));
        return success;
    }
}
