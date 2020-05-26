package com.demo.proxy.StaticProxyHas.proxy;

import com.demo.proxy.StaticProxyHas.service.UserDao;

public class LogUserProxy implements UserDao {
    private UserDao userDao;

    public LogUserProxy(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void query(String name) {
        System.out.println("打印日志");
        userDao.query(name);
    }
}
