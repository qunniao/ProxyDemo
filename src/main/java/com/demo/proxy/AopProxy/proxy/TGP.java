package com.demo.proxy.AopProxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 启动游戏的切面
 */
public class TGP implements InvocationHandler {

    private Object target;//目标对象

    public TGP(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行织入的代码，你可以控制哪些方法执行切入逻辑
        System.out.println("开始优化游戏环境...");

        //执行原有逻辑
        Object recv = method.invoke(target, args);

        //执行织入的代码
        System.out.println("游戏已正常启动...");
        return recv;
    }
}
