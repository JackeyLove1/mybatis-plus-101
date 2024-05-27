package com.example.mybatisplus;

import com.alibaba.fastjson2.JSON;
import com.example.mybatisplus.pojo.User;
import com.example.mybatisplus.utils.Mock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

@SpringBootTest
public class MpRedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void test01() {
        final String key = "key";
        final String value = "value";
        stringRedisTemplate.opsForValue().set(key, value, Duration.ofMinutes(1));
        String getValue = stringRedisTemplate.opsForValue().get(key);
        System.out.println(getValue);
        Assertions.assertEquals(value, getValue);
    }

    @Test
    public void test02(){
        User user = Mock.makeUser();
        String jsonUser = JSON.toJSONString(user);
        redisTemplate.opsForValue().set("user", jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
