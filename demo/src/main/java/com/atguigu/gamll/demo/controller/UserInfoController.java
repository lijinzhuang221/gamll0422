package com.atguigu.gamll.demo.controller;

import com.atguigu.gamll.demo.bean.UserInfo;
import com.atguigu.gamll.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("findAll")
    @ResponseBody // @ResponseBody 返回json 字符串， 还可以将数据直接显示到页面
    public List<UserInfo> findAll(){

        return userInfoService.findAll();
    }

    @RequestMapping("findUserByName")
    @ResponseBody
    public List<UserInfo> findUserByName(UserInfo userInfo){

        List<UserInfo> userInfoListByName = userInfoService.getUserInfoListByName(userInfo);

        return userInfoListByName;
    }

    @RequestMapping("findUserByNickName")
    @ResponseBody
    public List<UserInfo> findUserByNickName(UserInfo userInfo){

        return  userInfoService.getUserInfoListByNickName(userInfo);

    }

    @RequestMapping("addUser")
    @ResponseBody
    public void addUser(UserInfo userInfo){
        userInfo.setName("niu");
        userInfo.setLoginName("666");
     userInfoService.addUser(userInfo);
    }

    @RequestMapping("updUser")
    @ResponseBody
    public void updUser(UserInfo userInfo){
        userInfoService.updUser(userInfo);
    }

    @RequestMapping("delUser")
    @ResponseBody
    public void delUser(UserInfo userInfo){

        userInfoService.delUser(userInfo);
    }

}
