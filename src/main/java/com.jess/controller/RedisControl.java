package com.jess.controller;

import com.jess.common.util.redistakes.RedisBaiseTakes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zhongxuexi on 2018/6/17.
 */
@Controller
@RequestMapping("/redis")
public class RedisControl {
    @Resource(name="seeUserRedisTakes")
    private RedisBaiseTakes seeUserRedisTakes;

    @RequestMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        System.out.println("hello see");
        seeUserRedisTakes.add("hello1","zxm");
        System.out.println("+++++++++++++++++++"+seeUserRedisTakes.get("hello1"));
        mv.setViewName("hello");
        return mv;
    }

}
