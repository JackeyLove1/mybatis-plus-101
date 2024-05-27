package com.example.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatisplus.pojo.Order;
import com.example.mybatisplus.service.OrderService;
import com.example.mybatisplus.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author 15727
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2024-05-27 12:43:43
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

}




