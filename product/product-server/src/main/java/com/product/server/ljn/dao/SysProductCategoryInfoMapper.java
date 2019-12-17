package com.product.server.ljn.dao;

import com.product.base.ljn.entity.SysProductCategoryInfo;

import java.util.List;

public interface SysProductCategoryInfoMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(SysProductCategoryInfo record);

    int insertSelective(SysProductCategoryInfo record);

    SysProductCategoryInfo selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(SysProductCategoryInfo record);

    int updateByPrimaryKey(SysProductCategoryInfo record);

    List<SysProductCategoryInfo> findCategoryList();
}