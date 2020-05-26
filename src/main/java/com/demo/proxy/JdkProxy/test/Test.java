package com.demo.proxy.JdkProxy.test;


import com.demo.proxy.JdkProxy.dao.GloryDaoImpl;
import com.demo.proxy.JdkProxy.dao.PeaceDaoImpl;
import com.demo.proxy.JdkProxy.proxy.TgpCglib;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * cglib动态代理测试
 */
public class Test {
    public static void main(String[] args) throws IOException {
        TgpCglib cglib = new TgpCglib();
        //启动和平精英
        PeaceDaoImpl peace = (PeaceDaoImpl) cglib.getInstance(new PeaceDaoImpl());
        peace.play();

        System.out.println("================================");

        //启动王者荣耀
        GloryDaoImpl glory = (GloryDaoImpl) cglib.getInstance(new GloryDaoImpl());
        glory.play();
    }
}
