package com.demo.demo_web.user.service;

import com.demo.common.entity.SearchCriteria;
import com.demo.demo_web.user.dao.UserDao;
import com.demo.demo_web.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

}
