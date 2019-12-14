package com.user.server.ljn.dao;

import com.user.server.ljn.entity.SysProductCategoryInfo;

public interface SysProductCategoryInfoMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(SysProductCategoryInfo record);

    int insertSelective(SysProductCategoryInfo record);

    SysProductCategoryInfo selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(SysProductCategoryInfo record);

    int updateByPrimaryKey(SysProductCategoryInfo record);
}