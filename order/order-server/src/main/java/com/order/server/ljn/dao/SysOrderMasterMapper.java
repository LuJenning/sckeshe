package com.order.server.ljn.dao;

import com.order.base.ljn.entity.SysOrderMaster;

public interface SysOrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(SysOrderMaster record);

    int insertSelective(SysOrderMaster record);

    SysOrderMaster selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(SysOrderMaster record);

    int updateByPrimaryKey(SysOrderMaster record);

    void saveMaster(SysOrderMaster orderMaster);
}