package com.order.server.ljn.dao;

import com.order.base.ljn.entity.SysProductInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(SysProductInfo record);

    int insertSelective(SysProductInfo record);

    SysProductInfo selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(SysProductInfo record);

    int updateByPrimaryKey(SysProductInfo record);
}