package com.lm.demo.entity;

import com.lm.demo.filter.Filter;

import java.sql.SQLException;
import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MineAfternoon extends MineAbstract{

    private String dinnerTime;

    private String name;

    private String sex;

    public void readDirect () {
        System.out.println("我是：" + this.getName() + "我正在阅读");
    }

    public void bodyBuildDirect () {
        System.out.println("我是：" + this.getName() + "我正在健身");
    }

    public void bodySwimDirect () {
        System.out.println("我是：" + this.getName() + "我正在游泳");
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
            log.error("MineAfternoon初始化失败");
            throw e;
        } finally {
            inited = true;
            lock.unlock();
            if (init && log.isInfoEnabled()) {
                String msg = "{MineAfternoon-testMineAfternoon";

                if (this.name != null && !this.name.isEmpty()) {
                    msg += ",";
                    msg += this.name;
                }

                msg += "} inited";
                log.info(msg);
            }
        }
    }

    public String getDinnerTime() {
        return dinnerTime;
    }

    public void setDinnerTime(String dinnerTime) {
        this.dinnerTime = dinnerTime;
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
