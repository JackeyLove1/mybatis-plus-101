package com.example.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPPluginsTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPage(page, null);
        System.out.println(page);
        System.out.println(page.getRecords());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
    }

    @Test
    public void testPageByAge(){
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPageByAge(page, 20);
        System.out.println(page);
        System.out.println(page.getTotal());
    }
}
