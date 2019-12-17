package com.product.server.ljn.service;

import com.user.common.usercommon.entity.SysProductInfo;

import java.util.List;


public interface IProductService {

    List<SysProductInfo> getProductList();

    SysProductInfo getProduct(String priductId);

    void decreaseStock(int stock,String productId);

    int selectStockByProductId(String productId);

    SysProductInfo getProductInfoNyProductId(String productId);

    int addProduct(SysProductInfo sysProductInfo);
}
