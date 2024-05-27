package com.example.mybatisplus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.time.Duration;

@SpringBootTest
public class MpRedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01() {
        final String key = "key";
        final String value = "value";
        stringRedisTemplate.opsForValue().set(key, value, Duration.ofMinutes(1));
        String getValue = stringRedisTemplate.opsForValue().get(key);
        System.out.println(getValue);
        Assertions.assertEquals(value, getValue);
    }
}
