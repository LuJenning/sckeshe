package com.product.server.ljn.dao;

import com.user.common.usercommon.entity.SysProductInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysProductInfoMapper {
    int deleteByPrimaryKey(String productId);

    int insert(SysProductInfo record);

    int insertSelective(SysProductInfo record);

    SysProductInfo selectByPrimaryKey(String productId);

    int updateByPrimaryKeySelective(SysProductInfo record);

    int updateByPrimaryKey(SysProductInfo record);

    List<SysProductInfo> productList();

    SysProductInfo findProductByProductId(String productId);

    SysProductInfo getProduct(String productId);

    void decreaseStock(@Param("stock") int stock, @Param("productId") String productId);

    int selectStockByProductId(String productId);
}