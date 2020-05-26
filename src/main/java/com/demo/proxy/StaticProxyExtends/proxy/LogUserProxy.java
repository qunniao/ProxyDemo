package com.demo.proxy.StaticProxyExtends.proxy;

import com.demo.proxy.StaticProxyExtends.service.UserDaoImpl;

public class LogUserProxy extends UserDaoImpl {
    public void query(String name){
        System.out.println("打印日志");
        super.query(name);
    }
}
