package com.product.server.ljn.service;

import com.product.base.ljn.entity.SysProductCategoryInfo;

import java.util.List;

public interface ICategoryService {

    List<SysProductCategoryInfo> findCategoryList();
}
