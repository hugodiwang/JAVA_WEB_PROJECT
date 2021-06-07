package com.oa.service;

import com.oa.dao.RbacDao;
import com.oa.dao.UserDao;
import com.oa.entity.Node;
import com.oa.entity.User;
import com.oa.service.exception.BusinessException;
import com.oa.utils.MD5Utils;

import java.util.List;
import java.util.Locale;


public class UserService {
    private UserDao userDao = new UserDao();
    private RbacDao rbacDao = new RbacDao();
    /**
     * check the existence of username and password
     * if not, throw buisness exception
     * if yes, return user object
     * @param username
     * @param password
     * @return User object
     */
    public User checkLogin(String username, String password) {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            //user does not exist, throw new exception
            throw new BusinessException("L001", "user does not exist");
        }
        String encryotedPassword = MD5Utils.md5Digest(password,user.getSalt()).toLowerCase();
        if (!encryotedPassword.equals(user.getPassword().toLowerCase())) {
            throw new BusinessException("L002", "password is wrong");
        }
        System.out.println(user.getPassword());
        return user;
    }

    public List<Node> selectNodeByUserId(Long userId){
        List<Node> list = rbacDao.selectNodeByUserId(userId);
        return list;
    }
}
