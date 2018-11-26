package com.lm.demo.filter;

import com.lm.demo.entity.MineProxy;

public abstract class FilterAdapter implements Filter {

    @Override
    public void init(MineProxy mine) {

    }

    @Override
    public void washVegetable(FilterChain chain, String vegetableName) {
        chain.washVegetable(vegetableName);
    }

    @Override
    public void cook(FilterChain chain, String dishName) {
        chain.cook(dishName);
    }

    @Override
    public void eat(FilterChain chain, String tableware) {
        chain.eat(tableware);
    }

    @Override
    public void read(FilterChain chain) {
        chain.read();
    }

    @Override
    public void bodyBuild(FilterChain chain) {
        chain.bodyBuild();
    }

    @Override
    public void bodySwim(FilterChain chain) {
        chain.bodySwim();
    }
}
