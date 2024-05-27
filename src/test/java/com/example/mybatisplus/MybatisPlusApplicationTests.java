package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.utils.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    void testDeleteUserByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhangsan");
        map.put("age", 23);
        int result = userMapper.deleteByMap(map);
        System.out.println("result: "+ result);
    }

    @Test
    void testDeleteUserByIds(){
        var result = userMapper.deleteBatchIds(Arrays.asList(11L, 12L, 13L));
        System.out.println("result: "+ result);
    }

    @Test
    void testUpdateUser(){
        User user = Mock.makeUser();
        user.setId(4L);
        int result = userMapper.updateById(user);
        System.out.println("result: "+ result);
    }

    @Test
    void testBatchSelectIds(){
        var list  = Arrays.asList(1L, 2L, 3L);
        userMapper.selectBatchIds(list)
                .stream()
                .forEach(user -> System.out.println(user));
    }

    @Test
    void testSelectMapById(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    void testDeleteById(){
        userMapper.deleteById(1L);
    }

}
