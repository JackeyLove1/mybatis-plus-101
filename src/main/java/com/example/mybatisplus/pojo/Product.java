package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.example.mybatisplus.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @TableId
    private Long id;

    private String name;

    private Integer price;

    private GenderEnum gender;

    @Version
    private Integer version;
}
