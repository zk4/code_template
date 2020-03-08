package com.zk.dao;

import com.zk.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDaoTest {

    @Autowired
    UserDao userDao;
    @Test
    public void getById() {

        User byId = userDao.getById(1);
        System.out.println(byId.getName());
    }

    @Test
    public void insertUser() {
        User user = new User().setName("tmp");
        userDao.insert(user);
        System.out.println(user.getId());

    }
}