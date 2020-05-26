package com.demo.proxy.StaticProxyHas.service;

public class UserDaoImpl implements UserDao {
    public void query(String name){
        System.out.println("query name:"+name);
    }
}
