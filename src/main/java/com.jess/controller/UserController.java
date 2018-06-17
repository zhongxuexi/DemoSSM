package com.jess.controller;

import com.jess.common.EmailUtil;
import com.jess.pojo.User;
import com.jess.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongxuexi on 2018/6/13.
 */
@Controller
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;

   /* @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
*/
    @ResponseBody
    @RequestMapping(value = "/userJson")
    public List<User> selectUserAsJson(String id){
        List<User> users = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        try {
            logger.info("jess.zhong第一次打日志了，开始了！");
            users = userService.selectUser(map);
        }catch (Exception e){
            System.out.println(e.getMessage());
            logger.info(e);
        }

        System.out.println("userJson异常后继续执行语句-------------");
        return users;
    }
    ///WEB-INF/views/index.jsp
    @RequestMapping(value = "/userJsp")
    public ModelAndView selectUserAsJsp(String id){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        List<User> users = null;
        try {
            logger.info("jess.zhong第一次打日志了，开始了！");
            users = userService.selectUser(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.info(e);
        }
        System.out.println("userJson异常后继续执行语句-------------");
        ModelAndView model = new ModelAndView();
        model.addObject("users",users);
        model.setViewName("index");
        return model;
    }
}

