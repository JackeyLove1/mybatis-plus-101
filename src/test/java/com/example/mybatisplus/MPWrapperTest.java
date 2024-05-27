package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MPWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "a")
                .between("age", 20, 30)
                .isNotNull("email");
        userMapper.selectList(wrapper)
                .stream()
                .forEach(user -> System.out.println(user));
    }

    @Test
    public void test02(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("age")
                .orderByAsc("id");
        userMapper.selectList(wrapper)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void test04(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setUserName("zhangsan");
        user.setEmail("test@email.com");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test05(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("user_name", "ja")
                .and(item -> item.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setUserName("hehe");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test06(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age", "email");
        userMapper.selectMaps(queryWrapper)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void test07(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from t_user where id <= 100");
        userMapper.selectList(queryWrapper)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void test08(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("user_name", "ja")
                .and(item -> item.gt("age", 20).or().isNull("email"));
        userUpdateWrapper.set("user_name", "xiaohei").set("email", "123456@test.com");
        userMapper.update(userUpdateWrapper);
    }

    @Test
    public void test09(){
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null && ageEnd != null){
            queryWrapper.between("age", ageBegin, ageEnd);
        }
        userMapper.selectList(queryWrapper)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void test10(){
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        userMapper.selectList(queryWrapper)
                .stream()
                .forEach(System.out::println);
    }

    @Test
    public void test11(){
        String username = "";
        Integer ageBegin = 10;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(username), User::getName, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        userMapper.selectList(lambdaQueryWrapper)
                .stream()
                .forEach(System.out::println);
    }
}
