package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @TableName("t_user")
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "name")
    private String name;

    private Integer age;

    private String email;

    private String password;

    @TableLogic
    @TableField(value = "is_deleted")
    private Short isDeleted;
}
