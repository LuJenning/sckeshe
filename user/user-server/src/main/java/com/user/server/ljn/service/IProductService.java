package com.user.server.ljn.service;

import com.base.ljn.dto.ProductDTO;
import com.user.server.ljn.entity.SysProductInfo;

import java.util.List;

public interface IProductService {

    List<SysProductInfo>  getProductList();
}
