package com.demo.proxy.StaticProxyHas.proxy;

import com.demo.proxy.StaticProxyHas.service.UserDao;

public class TimeUserProxy implements UserDao {
    private UserDao userDao;

    public TimeUserProxy(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public void query(String name) {
        System.out.println("查询时间");
        userDao.query(name);
    }
}
