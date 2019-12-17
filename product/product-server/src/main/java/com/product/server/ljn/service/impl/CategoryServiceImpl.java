package com.product.server.ljn.service.impl;

import com.product.base.ljn.entity.SysProductCategoryInfo;
import com.product.server.ljn.dao.SysProductCategoryInfoMapper;
import com.product.server.ljn.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private SysProductCategoryInfoMapper mapper;

    @Override
    public List<SysProductCategoryInfo> findCategoryList() {
        return mapper.findCategoryList();
    }
}
