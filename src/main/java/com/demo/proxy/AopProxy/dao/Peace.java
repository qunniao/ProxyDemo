package com.demo.proxy.AopProxy.dao;

/**
 * 和平精英游戏
 */
public class Peace implements Game {
    @Override
    public void play() {
        System.out.println("开始启动和平精英...");
    }

}
