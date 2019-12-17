package com.product.server.ljn.service.impl;

import com.product.server.ljn.dao.SysProductInfoMapper;
import com.product.server.ljn.service.IProductService;
import com.user.common.usercommon.entity.SysProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    private SysProductInfoMapper mapper;

    @Override
    public List<SysProductInfo> getProductList() {
        return mapper.productList();
    }

    @Override
    public SysProductInfo getProduct(String productId) {
        return mapper.getProduct(productId);
    }

    @Override
    public void decreaseStock(int stock,String productId) {
        mapper.decreaseStock(stock,productId);
    }

    @Override
    public int selectStockByProductId(String productId) {
        return mapper.selectStockByProductId(productId);
    }

    @Override
    public SysProductInfo getProductInfoNyProductId(String productId) {
        return mapper.findProductByProductId(productId);
    }

    @Override
    public int addProduct(SysProductInfo sysProductInfo) {
        return mapper.insert(sysProductInfo);
    }

}
