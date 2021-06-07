package com.oa.utils;

import org.junit.Test;

public class MybatisUtilsTester {
    @Test
    public void testCase1(){
        String res = (String) MybatisUtils.executeQuery(sqlSession -> {
            String out = (String) sqlSession.selectOne("test.sample");
            return out;
        });
        System.out.println(res);
    }
}
