package com.oa.dao;

import com.oa.entity.User;
import com.oa.utils.MybatisUtils;

public class UserDao {
    /**
     * use username to query the user table
     * @param username
     * @return User or null
     */
    public User selectByUsername(String username){
        User user = (User) MybatisUtils.executeQuery(sqlSession -> sqlSession.selectOne("usermapper.selectByUsername", username));
        return user;
    }
}
