package com.lm.demo.filter;

public abstract class FilterEventAdapter extends FilterAdapter {

    public FilterEventAdapter(){

    }

    @Override
    public void washVegetable(FilterChain chain, String vegetableName) {
        washVegetableBefore(chain , vegetableName);

        super.washVegetable(chain, vegetableName);

        washVegetableAfter(chain , vegetableName);
    }

    public void washVegetableBefore(FilterChain chain, String vegetableName){

    }

    public void washVegetableAfter(FilterChain chain, String vegetableName){

    }

    @Override
    public void cook(FilterChain chain, String dishName) {
        cookBefore(chain , dishName);

        super.cook(chain, dishName);

        cookAfter(chain , dishName);
    }

    public void cookBefore(FilterChain chain, String dishName){

    }

    public void cookAfter(FilterChain chain, String dishName){

    }

    @Override
    public void eat(FilterChain chain, String tableware) {
        eatBefore(chain , tableware);

        super.eat(chain, tableware);

        eatAfter(chain , tableware);
    }

    public void eatBefore(FilterChain chain, String tableware){

    }

    public void eatAfter(FilterChain chain, String tableware){

    }
}
