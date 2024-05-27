package com.example.mybatisplus;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

public class MpDigtialTest {
    final String str = "Hello, World!";
    @Test
    public void testMD5(){
        String md5 = DigestUtils.md5Hex(str);
        System.out.println(md5);
    }

    @Test
    public void testSHA1(){
        String sha1 = DigestUtils.sha1Hex(str);
        System.out.println(sha1);
    }
}
