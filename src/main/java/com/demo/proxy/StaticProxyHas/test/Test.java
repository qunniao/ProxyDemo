package com.demo.proxy.StaticProxyHas.test;


import com.demo.proxy.StaticProxyHas.proxy.LogUserProxy;
import com.demo.proxy.StaticProxyHas.proxy.TimeUserProxy;
import com.demo.proxy.StaticProxyHas.service.UserDao;
import com.demo.proxy.StaticProxyHas.service.UserDaoImpl;

/**
 * 静态代理-聚合实现方式
 */
public class Test {
    public static void main(String[] args){
        UserDao userDao = new UserDaoImpl();
        UserDao proxyLog = new LogUserProxy(userDao);
        UserDao proxyTime = new TimeUserProxy(proxyLog);
        proxyTime.query("静态代理-聚合");

    }
}
