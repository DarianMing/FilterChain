package com.lm.demo.controller;

import com.lm.demo.entity.MineMorning;
import com.lm.demo.filter.Filter;
import com.lm.demo.filter.stat.LogFilter;
import com.lm.demo.filter.stat.WashVegetableFilter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/*
    参考博客 http://herman-liu76.iteye.com/blog/2308563
             https://blog.csdn.net/lqzkcx3/article/details/78397500
             http://turbosky.iteye.com/blog/2325726
             https://blog.csdn.net/u013038630/article/details/75670208
 */

@Controller
public class StartWeekend {

    @GetMapping("start")
    @ResponseBody
    public String start(){
        MineMorning mine = null;
        try {
            mine = new MineMorning();
            mine.setName("测试君");
            List<Filter> filters = new ArrayList<>();
            WashVegetableFilter washVegetableFilter = new WashVegetableFilter();
            filters.add(washVegetableFilter);
            LogFilter logFilter = new LogFilter();
            filters.add(logFilter);
            mine.setProxyFilters(filters);
            mine.getWashVegetable("菠菜");
            mine.getCook("红烧肉");
            mine.getEat("筷子");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "哈哈哈";
    }
}
