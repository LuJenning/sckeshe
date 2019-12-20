package com.order.server.ljn.dao;

import com.order.base.ljn.entity.SysOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysOrderDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(SysOrderDetail record);

    int insertSelective(SysOrderDetail record);

    SysOrderDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(SysOrderDetail record);

    int updateByPrimaryKey(SysOrderDetail record);

    void save(SysOrderDetail orderDetail);

    List<SysOrderDetail> findOrderDetail();
}