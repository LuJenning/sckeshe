package com.user.client.ljn.userfeign;

import com.base.ljn.dto.ProductDTO;
import com.user.server.ljn.entity.SysProductInfo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserFeignFallbackImpl implements UserFeign {


    @Override
    public List<SysProductInfo> getProductList() {
        return null;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {

    }
}
