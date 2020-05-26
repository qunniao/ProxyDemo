package com.demo.proxy.StaticProxyExtends.test;

import com.demo.proxy.StaticProxyExtends.proxy.LogUserProxy;
import com.demo.proxy.StaticProxyExtends.service.UserDaoImpl;

/**
 * 静态代理-继承实现方式
 */
public class Test {
    public static void main(String[] args){
        UserDaoImpl userDao = new LogUserProxy();
        userDao.query("静态代理-继承：之茵");
    }
}
