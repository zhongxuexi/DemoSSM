package com.jess.service.impl;

import com.jess.common.EmailUtil;
import com.jess.dao.UserDao;
import com.jess.pojo.User;
import com.jess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * Created by zhongxuexi on 2018/6/13.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Override
    public List<User> selectUser(Map<String, Object> map) throws Exception {
        try {
            int a=5/0;
        }catch (Exception e){
            String info = "钟学曦的模块：发生了异常，类："+this.getClass().getName()+"方法：selectUser(),异常信息为："+e.getMessage();
            EmailUtil.sendHtmlMail("jess.zhong@aliyun.com","线上异常报告",info);
            System.out.println("发送成功");
            throw new Exception(info);
        }
        return userDao.selectUser(map);
    }
}
