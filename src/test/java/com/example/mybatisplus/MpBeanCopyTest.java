package com.example.mybatisplus;

import com.example.mybatisplus.pojo.SourceBean;
import com.example.mybatisplus.pojo.TargetBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

public class MpBeanCopyTest {
    @Test
    void testBeanCopy(){
        SourceBean sourceBean = new SourceBean();
        sourceBean.setAge(100);
        sourceBean.setName("Jacky");

        TargetBean targetBean = new TargetBean();
        BeanUtils.copyProperties(sourceBean, targetBean);
        System.out.println(targetBean);
    }
}
