package com.example.mybatisplus;

import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.service.UserService;
import com.example.mybatisplus.utils.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testCount(){
        long count = userService.count();
        System.out.println("count: " + count);
    }

    @Test
    public void testSaveBatch(){
        List<User> list = new ArrayList<>();
        final int nums = 100;
        for (int i = 0; i < nums; i++){
            list.add(Mock.makeUser());
        }
        boolean result = userService.saveBatch(list);
        System.out.println("result: " + result);
    }


}
