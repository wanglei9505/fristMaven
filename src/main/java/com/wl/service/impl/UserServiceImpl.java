package com.wl.service.impl;

import com.wl.dao.UserDao;
import com.wl.po.User;
import com.wl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WL on 2017/7/23.
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User getUser(String id) {
        return userDao.getUser(id);
    }
}
