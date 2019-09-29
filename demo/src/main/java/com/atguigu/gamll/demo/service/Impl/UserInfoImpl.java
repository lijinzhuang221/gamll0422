package com.atguigu.gamll.demo.service.Impl;

import com.atguigu.gamll.demo.bean.UserInfo;
import com.atguigu.gamll.demo.mapper.UserInfoMapper;
import com.atguigu.gamll.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserInfoImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll();
        return userInfoList;
    }

    @Override
    public UserInfo getUserInfoByName(String name) {

        return null;
    }

    @Override
    public List<UserInfo> getUserInfoListByName(UserInfo userInfo) {

        return  userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> getUserInfoListByNickName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andLike("nickName","%"+userInfo.getNickName()+"%");
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updUser(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",userInfo.getName());
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(6);
        list.add(9);
        example.createCriteria().andBetween("id",4,6);
//        userInfoMapper.delete(userInfo);
        userInfoMapper.deleteByExample(example);

    }
}
