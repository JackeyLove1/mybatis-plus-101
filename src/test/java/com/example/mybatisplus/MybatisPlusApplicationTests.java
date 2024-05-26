package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.utils.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println("Hello, World!");
    }

    @Test
    void testSelectAll(){
        userMapper.selectList(null)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    void testInsertUser(){
        User user = Mock.makeUser();
        userMapper.insert(user);
        System.out.println(user.getId());
    }

}
