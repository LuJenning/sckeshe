package com.user.server.ljn.service.impl;


import com.user.common.usercommon.entity.SysUserInfo;
import com.user.server.ljn.dao.SysUserInfoMapper;
import com.user.server.ljn.service.IUserService;
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
