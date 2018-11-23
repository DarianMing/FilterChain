package com.lm.demo.entity;

import com.lm.demo.filter.Filter;
import com.lm.demo.filter.FilterChainImpl;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MineMorning extends MineAbstract {

    private String getUpTime;

    private String napTime;

    private String name;

    private String sex;

    public void washVegetableDirect (String vegetableName) {
        System.out.println("我是：" + this.getName() + "我正在洗" + vegetableName);
    }

    public void cookDirect (String dishName) {
        System.out.println("我是：" + this.getName() + "我正在烹饪" + dishName);
    }

    public void eatDirect (String tableware) {
        System.out.println("我是：" + this.getName() + "我正在用" + tableware + "就餐");
    }

    public void getWashVegetable(String vegetableName) throws Exception{
        init();//防御性编程

        if (filters.size() > 0) {
            FilterChainImpl filterChain = new FilterChainImpl(this);
            filterChain.washVegetable(vegetableName);
        } else {
            eatDirect(vegetableName);
        }
    }

    public void getCook (String dishName) throws Exception{
        init();//防御性编程

        if (filters.size() > 0) {
            FilterChainImpl filterChain = new FilterChainImpl(this);
            filterChain.cook(dishName);
        } else {
            eatDirect(dishName);
        }
    }

    public void getEat(String tableware) throws Exception{
        init();//防御性编程

        if (filters.size() > 0) {
            FilterChainImpl filterChain = new FilterChainImpl(this);
            filterChain.eat(tableware);
        } else {
            eatDirect(tableware);
        }
    }

    public void init() throws Exception{
        if (inited) {
            return;
        }

        final ReentrantLock lock = this.lock;
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            throw new Exception("interrupt", e);
        }

        boolean init = false;
        try {
            if (inited) {
                return;
            }

            for (Filter filter : filters) {
                filter.init(this);
            }

            init = true;
        } catch (Exception e) {
            log.error("MineMorning初始化失败");
            throw e;
        } finally {
            inited = true;
            lock.unlock();
            if (init && log.isInfoEnabled()) {
                String msg = "{MineMorning-testMineMorning";

                if (this.name != null && !this.name.isEmpty()) {
                    msg += ",";
                    msg += this.name;
                }

                msg += "} inited";
                log.info(msg);
            }
        }
    }

    public String getGetUpTime() {
        return getUpTime;
    }

    public void setGetUpTime(String getUpTime) {
        this.getUpTime = getUpTime;
    }

    public String getNapTime() {
        return napTime;
    }

    public void setNapTime(String napTime) {
        this.napTime = napTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
