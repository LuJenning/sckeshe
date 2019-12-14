package com.user.server.ljn.dao;

import com.user.server.ljn.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUserInfo record);

    int insertSelective(SysUserInfo record);

    SysUserInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUserInfo record);

    int updateByPrimaryKey(SysUserInfo record);

    SysUserInfo selectByUsernameAndPwd(@Param("username") String u, @Param("password") String p);
}