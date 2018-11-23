package com.lm.demo.filter;

import com.lm.demo.entity.MineProxy;

public abstract class FilterAdapter implements Filter {

    @Override
    public void init(MineProxy mine) {

    }

    @Override
    public void washVegetable(FilterChain chain, String vegetableName) {

    }

    @Override
    public void cook(FilterChain chain, String dishName) {

    }

    @Override
    public void eat(FilterChain chain, String tableware) {

    }

    @Override
    public void read(FilterChain chain) {

    }

    @Override
    public void bodyBuild(FilterChain chain) {

    }

    @Override
    public void bodySwim(FilterChain chain) {

    }
}
