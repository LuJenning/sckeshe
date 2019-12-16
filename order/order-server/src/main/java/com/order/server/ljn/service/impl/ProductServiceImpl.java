package com.order.server.ljn.service.impl;


import com.order.server.ljn.dao.SysProductInfoMapper;
import com.order.server.ljn.service.IProductService;
import com.user.common.usercommon.entity.SysProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private SysProductInfoMapper mapper;

    @Override
    public List<SysProductInfo> getProductList() {
        return null;
    }
}
