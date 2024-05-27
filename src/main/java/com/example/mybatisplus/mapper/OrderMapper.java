package com.example.mybatisplus.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.example.mybatisplus.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 15727
* @description 针对表【t_order】的数据库操作Mapper
* @createDate 2024-05-27 12:43:43
* @Entity com.example.mybatisplus.pojo.Order
*/
public interface OrderMapper extends BaseMapper<Order> {
    int insertSelective(Order order);

    int deleteById(@Param("id") Long id);

    int updateIdById(@Param("id") Long id, @Param("oldId") Long oldId);

    List<Order> selectById(@Param("id") Long id);


}




