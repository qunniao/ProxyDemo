package com.demo.proxy.AopProxy.dao;

/**
 * 王者荣耀游戏
 */
public class Glory implements Game {
    @Override
    public void play() {
        System.out.println("开始启动王者荣耀...");
    }

}
