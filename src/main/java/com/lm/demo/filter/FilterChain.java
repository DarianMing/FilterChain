package com.lm.demo.filter;

import com.lm.demo.entity.MineProxy;

public interface FilterChain {

    MineProxy getMineDay();

    int getFilterSize();

    int getPos();

    FilterChain cloneChain();

    void washVegetable (String vegetableName);

    void cook (String dishName);

    void eat (String tableware);

    void read ();

    void bodyBuild ();

    void bodySwim ();

}
