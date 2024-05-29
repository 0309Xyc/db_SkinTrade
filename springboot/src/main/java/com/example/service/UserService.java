package com.example.service;

import com.example.exception.CustomException;
import com.example.mapper.UserMapper;
import com.example.pojo.Params;
import com.example.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public PageInfo<User> findBySearch(Params params) {
        //分页
        PageHelper.startPage(params.getPageNum(),params.getPageSize());
        List<User> list = userMapper.findBySearch(params);
        return PageInfo.of(list);
    }

    public List<User> getUser() {
        return userMapper.getUser();
        //return userMapper.selectAll();
    }

    public void add(User user) {
        if(user.getUsername()==null || "".equals(user.getUsername())) {
            throw new CustomException("用户名不能为空！");
        }
        if(user.getPassword()==null || "".equals(user.getPassword())) {
            throw new CustomException("密码不能为空！");
        }
        if(user.getEmail()==null || "".equals(user.getEmail())) {
            throw new CustomException("邮箱不能为空！");
        }
        User user1 = userMapper.findByUsername(user.getUsername());
        if(user1!=null) {
            throw new CustomException("用户名已存在！");
        }
        userMapper.insertUser(user.getUsername(),user.getPassword(),user.getEmail());
    }

    public User login(User user) {//登录处理
        //非空判断
        if(user.getUsername()==null || "".equals(user.getUsername())) {
            throw new CustomException("用户名不能为空！");
        }
        if(user.getPassword()==null || "".equals(user.getPassword())) {
            throw new CustomException("密码不能为空！");
        }
        //去数据库查信息
        User user1 = userMapper.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(user1 == null) {
            throw new CustomException("用户名或密码错误！");
        }
        return user1;
    }
}
