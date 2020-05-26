package com.demo.proxy.AopProxy.test;


import com.demo.proxy.AopProxy.dao.Game;
import com.demo.proxy.AopProxy.dao.Glory;
import com.demo.proxy.AopProxy.dao.Peace;
import com.demo.proxy.AopProxy.proxy.TGP;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * AOP动态代理测试
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //需要代理的类接口，被代理类实现的多个接口都必须在这这里定义
        Class[] proxyInterface = new Class[] {Game.class};
        //构建AOP的Advice，这里需要传入业务类的实例
        TGP handler = new TGP(new Peace());
        //生成代理类的字节码加载器
        ClassLoader classLoader = Peace.class.getClassLoader();
        //织入器，织入代码并生成代理类
        Game proxyPeace = (Game) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
        proxyPeace.play();
        System.out.println("================================");
        //启动王者荣耀
        Game proxyGlory = (Game) Proxy.newProxyInstance(Glory.class.getClassLoader(), proxyInterface, new TGP(new Glory()));
        proxyGlory.play();




    }
}
