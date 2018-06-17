package com.jess.service;

import com.jess.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by zhongxuexi on 2018/6/13.
 */
public interface UserService {
    List<User> selectUser(Map<String,Object> map) throws Exception;
}
