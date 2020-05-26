package com.demo.proxy.JdkProxy.proxy;


import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * 启动游戏的切面
 * 使用cglib动态代理
 */
public class TgpCglib implements MethodInterceptor {

    private Object target;

    /**
     * 创建代理对象
     *
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理
        return enhancer.create();
    }

    //回调方法
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        //执行织入的代码，你可以控制哪些方法执行切入逻辑
        System.out.println("开始优化游戏环境...");

        methodProxy.invokeSuper(obj, args);

        //执行织入的代码
        System.out.println("游戏已正常启动...");

        return null;
    }
}