package com.example.mybatisplus;

import com.example.mybatisplus.enums.GenderEnum;
import com.example.mybatisplus.mapper.ProductMapper;
import com.example.mybatisplus.pojo.Product;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MpProduct {
    @Autowired
    private ProductMapper productMapper;

    static final Faker faker = new Faker();
    @Test
    public void test01(){
        Product product = new Product();
        product.setGender(GenderEnum.MALE);
        product.setName(faker.name().name());
        productMapper.insert(product);
    }
}
