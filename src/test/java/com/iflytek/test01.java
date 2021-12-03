package com.iflytek;

import com.iflytek.utils.MD5Util;
import org.junit.Test;

/**
 * @author congchen6
 * @date 2021-12-01 16:02
 */
public class test01 {
    @Test
    public void testMD(){
        String a="123456";
        System.out.println(MD5Util.getMD5(a));
    }
}
