package com.lm.demo.filter;

import com.lm.demo.entity.MineMorning;
import com.lm.demo.entity.MineProxy;

import java.util.List;

public class FilterChainImpl implements FilterChain {
    protected int pos = 0;

    private final MineProxy mine;

    private final int filterSize;

    public FilterChainImpl(MineProxy mine){
        this.mine = mine;
        this.filterSize = getFilters().size();
    }

    public FilterChainImpl(MineProxy mine, int pos){
        this.mine = mine;
        this.pos = pos;
        this.filterSize = getFilters().size();
    }

    public MineProxy getMine() {
        return mine;
    }

    public int getFilterSize() {
        return filterSize;
    }

    public int getPos() {
        return pos;
    }

    public void reset() {
        pos = 0;
    }

    @Override
    public MineProxy getMineDay() {
        return mine;
    }

    @Override
    public FilterChain cloneChain() {
        return new FilterChainImpl(mine, pos);
    }

    @Override
    public void washVegetable(String vegetableName) {
        if (this.pos < filterSize) {
            nextFilter()
                    .washVegetable(this, vegetableName);
            return;
        }
        System.out.println("已经到达{washVegetable}动作过滤链顶端");
        ((MineMorning)mine).washVegetableDirect(vegetableName);
    }

    @Override
    public void cook(String dishName) {
        if (this.pos < filterSize) {
            nextFilter()
                    .washVegetable(this, dishName);
            return;
        }
        System.out.println("已经到达{cook}动作过滤链顶端");
        ((MineMorning)mine).cookDirect(dishName);
    }

    @Override
    public void eat(String tableware) {
        if (this.pos < filterSize) {
            nextFilter()
                    .washVegetable(this, tableware);
            return;
        }
        System.out.println("已经到达{eat}动作过滤链顶端");
        ((MineMorning)mine).eatDirect(tableware);
    }

    @Override
    public void read() {

    }

    @Override
    public void bodyBuild() {

    }

    @Override
    public void bodySwim() {

    }

    public List<Filter> getFilters() {
        return mine.getProxyFilters();
    }

    private Filter nextFilter() {
        return getFilters()
                .get(pos++);
    }
}
