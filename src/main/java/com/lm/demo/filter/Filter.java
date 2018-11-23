package com.lm.demo.filter;

import com.lm.demo.entity.MineProxy;

public interface Filter {

    void init(MineProxy mine);

    void washVegetable (FilterChain chain , String vegetableName);

    void cook (FilterChain chain , String dishName);

    void eat (FilterChain chain , String tableware);

    void read (FilterChain chain);

    void bodyBuild (FilterChain chain);

    void bodySwim (FilterChain chain);
}
