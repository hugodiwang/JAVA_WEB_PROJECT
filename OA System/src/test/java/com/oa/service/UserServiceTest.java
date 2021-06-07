package com.oa.service;

import com.oa.entity.Node;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class UserServiceTest{
    private UserService userService = new UserService();
    @Test
    public void testCheckLogin1() {
        userService.checkLogin("uu","test");
    }
    @Test
    public void testCheckLogin2() {
        userService.checkLogin("m8","test");
    }

    @Test
    public void testSelectUserById(){
        List<Node> list  = userService.selectNodeByUserId(2l);
        System.out.println(list);
    }

}