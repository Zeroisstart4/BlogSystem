package com.blog.service;

import com.blog.dao.UserDao;
import com.blog.pojo.User;
import com.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou
 * @create 2021-6-14 15:44
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public User checkUser(String username, String password) {
        User user = userDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
