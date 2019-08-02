package com.hl.springsecurity;

import com.hl.springsecurity.dao.UserMapper;
import com.hl.springsecurity.model.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        User admin = userMapper.getUserFromDatabase("admin");
        System.out.println(admin);
    }

    @Test
    public void test1(){
        System.out.println("hello");
    }
}
