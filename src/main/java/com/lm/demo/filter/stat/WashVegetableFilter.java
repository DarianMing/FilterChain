package com.lm.demo.filter.stat;

import com.lm.demo.entity.MineProxy;
import com.lm.demo.filter.FilterChain;
import com.lm.demo.filter.FilterEventAdapter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WashVegetableFilter extends FilterEventAdapter {

    private final Lock lock  = new ReentrantLock();

    public WashVegetableFilter(){

    }

    @Override
    public void init(MineProxy mine) {
//        super.init(mine);
        lock.lock();
        try {
            System.out.println("WashVegetableFilter初始化");
        } finally {
            lock.unlock();
        }
    }

      //如果直接覆盖动作，那么before和after方法就会失效，此时需要在本方法中重新调用before和after方法
//    @Override
//    public void washVegetable(FilterChain chain, String vegetableName) {
////        this.washVegetableBefore(chain,vegetableName);
//        vegetableName = vegetableName + "、(WashVegetableFilter)莴苣";
//        //super.washVegetable(chain, vegetableName);
//          chain.washVegetable(vegetableName);
////        this.washVegetableAfter(chain,vegetableName);
//    }

    @Override
    public void washVegetableBefore(FilterChain chain, String vegetableName) {
        System.out.println("我是WashVegetableFilter，我要告诉大家要开始洗菜啦！");
        //super.washVegetableBefore(chain, vegetableName);
    }

    @Override
    public void washVegetableAfter(FilterChain chain, String vegetableName) {
        //super.washVegetableAfter(chain, vegetableName);
        System.out.println("我是WashVegetableFilter，我要告诉大家已经洗完菜啦！");
    }

    @Override
    public void cook(FilterChain chain, String dishName) {
        this.cookBefore(chain,dishName);
        chain.cook(dishName);
        //super.cook(chain, dishName);
        this.cookAfter(chain,dishName);
    }

    @Override
    public void cookBefore(FilterChain chain, String dishName) {
        //super.cookBefore(chain, dishName);
        System.out.println("烹饪" + dishName + "之前");
    }

    @Override
    public void cookAfter(FilterChain chain, String dishName) {
        //super.cookAfter(chain, dishName);
        System.out.println("烹饪" + dishName + "之后");
    }

    @Override
    public void eat(FilterChain chain, String tableware) {
        this.eatBefore(chain,tableware);
        tableware = tableware + ",(WashVegetableFilter)汤匙";
        //super.eat(chain, tableware);
        chain.eat(tableware);
        this.eatAfter(chain,tableware);
    }

    @Override
    public void eatBefore(FilterChain chain, String tableware) {
        //super.eatBefore(chain, tableware);
        System.out.println("用" + tableware + "就餐之前");
    }

    @Override
    public void eatAfter(FilterChain chain, String tableware) {
        //super.eatAfter(chain, tableware);
        System.out.println("用" + tableware + "就餐之后");
    }

    @Override
    public void read(FilterChain chain) {
        super.read(chain);
    }

    @Override
    public void bodyBuild(FilterChain chain) {
        super.bodyBuild(chain);
    }

    @Override
    public void bodySwim(FilterChain chain) {
        super.bodySwim(chain);
    }
}
