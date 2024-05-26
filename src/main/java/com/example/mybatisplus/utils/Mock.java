package com.example.mybatisplus.utils;

import com.example.mybatisplus.pojo.User;
import com.github.javafaker.Faker;

public class Mock {
    private static final Faker faker = new Faker();
    public static User makeUser() {
        User user = new User();

        user.setName(faker.name().fullName());
        user.setAge(faker.number().numberBetween(1, 100));
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        return user;
    }
}
