package com.lm.demo.filter.stat;

import com.lm.demo.entity.MineProxy;
import com.lm.demo.filter.FilterChain;
import com.lm.demo.filter.FilterEventAdapter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LogFilter extends FilterEventAdapter {

    private final Lock lock = new ReentrantLock();

    public LogFilter(){

    }

    @Override
    public void init(MineProxy mine) {
        lock.lock();
        try {
            System.out.println("LogFilter初始化成功");
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void washVegetableBefore(FilterChain chain, String vegetableName) {
        System.out.println("我是LogFilter，我要告诉大家要开始洗菜啦！");
    }

    @Override
    public void washVegetableAfter(FilterChain chain, String vegetableName) {
        System.out.println("我是LogFilter，我要告诉大家已经洗完菜啦！");
    }

    @Override
    public void cookBefore(FilterChain chain, String dishName) {
        System.out.println("我是LogFilter，我要告诉大家要开始烹饪啦！");
    }

    @Override
    public void cookAfter(FilterChain chain, String dishName) {
        System.out.println("我是LogFilter，我要告诉大家要烹饪完毕啦！");
    }

    @Override
    public void eatBefore(FilterChain chain, String tableware) {
        System.out.println("我是LogFilter，我要告诉大家要用餐啦！");
    }

    @Override
    public void eatAfter(FilterChain chain, String tableware) {
        System.out.println("我是LogFilter，我要告诉大家用餐完毕啦！");
    }
}
