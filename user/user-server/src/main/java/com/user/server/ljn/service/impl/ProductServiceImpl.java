package com.user.server.ljn.service.impl;


import com.base.ljn.dto.ProductDTO;
import com.user.server.ljn.dao.SysProductInfoMapper;
import com.user.server.ljn.entity.SysProductInfo;
import com.user.server.ljn.service.IProductService;
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
