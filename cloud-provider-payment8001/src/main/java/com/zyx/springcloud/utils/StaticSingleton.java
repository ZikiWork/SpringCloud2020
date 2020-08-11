package com.zyx.springcloud.utils;

/**
 * Author: Administrator
 * Date:  2020/6/21 13:28
 */
public class StaticSingleton {

    /**
     * 静态内部类
     */
    static class innerStaticSingleton {
        private static StaticSingleton singleton = new StaticSingleton();
    }

    private StaticSingleton() {

    }

    /**
     * 获取单例对象
     *
     * @return StaticSingleton
     */
    public static StaticSingleton getInstance() {
        return innerStaticSingleton.singleton;
    }




}
