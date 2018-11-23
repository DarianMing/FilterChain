package com.lm.demo.entity;

import com.lm.demo.filter.Filter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public abstract class MineAbstract implements MineProxy {

    protected List<Filter> filters = new CopyOnWriteArrayList<Filter>();

    private boolean  clearFiltersEnable = true;

    protected volatile boolean inited = false;

    protected ReentrantLock lock = new ReentrantLock(false);

    @Override
    public List<Filter> getProxyFilters() {
        return filters;
    }

    public void setProxyFilters(List<Filter> filters) {
        if (filters != null) {
            this.filters.addAll(filters);
        }
    }

    public String[] getFilterClasses() {
        List<Filter> filterConfigList = getProxyFilters();

        List<String> classes = new ArrayList<String>();
        for (Filter filter : filterConfigList) {
            classes.add(filter.getClass().getName());
        }

        return classes.toArray(new String[classes.size()]);
    }

    public void setFilters(List<Filter> filters) throws Exception {
//        if (filters != null && filters.startsWith("!")) {
//            filters = filters.substring(1);
//            this.clearFilters();
//        }
        this.filters.addAll(filters);
        //this.addFilters(filters);
    }

    public void clearFilters() {
        if (!isClearFiltersEnable()) {
            return;
        }
        this.filters.clear();
    }

    public boolean isClearFiltersEnable() {
        return clearFiltersEnable;
    }

    public void addFilters(String filters) throws SQLException {
        if (filters == null || filters.length() == 0) {
            return;
        }

        String[] filterArray = filters.split("\\,");

//        for (String item : filterArray) {
//            FilterManager.loadFilter(this.filters, item.trim());
//        }
    }
}
