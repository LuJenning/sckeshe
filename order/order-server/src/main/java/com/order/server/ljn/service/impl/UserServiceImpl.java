package com.order.server.ljn.service.impl;


import com.order.base.ljn.entity.SysUserInfo;
import com.order.server.ljn.dao.SysUserInfoMapper;
import com.order.server.ljn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private SysUserInfoMapper mapper;

    @Override
    public SysUserInfo login(String u, String p) {
        return mapper.selectByUsernameAndPwd(u,p);
    }
}
