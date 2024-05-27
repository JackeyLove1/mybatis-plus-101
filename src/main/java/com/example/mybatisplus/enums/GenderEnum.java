package com.example.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;

@Generated
@ToString
public enum GenderEnum {
    MALE((short) 1, "MAN"),

    FEMALE((short) 0, "FEMALE");

    @EnumValue
    private final Short sex;

    private final String name;

    GenderEnum(Short sex, String name) {
        this.sex = sex;
        this.name = name;
    }

}
