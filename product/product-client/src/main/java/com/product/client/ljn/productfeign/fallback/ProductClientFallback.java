package com.product.client.ljn.productfeign.fallback;

import com.base.ljn.dto.BuyProductDTO;
import com.base.ljn.dto.ProductDTO;
import com.product.base.ljn.entity.SysProductInfo;
import com.product.client.ljn.productfeign.feign.ProductClient;
import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductClient {


    @Override
    public void createOrderFor(BuyProductDTO buyProductDTO) {

    }

    @Override
    public SysProductInfo getList(ProductDTO productDTO) {


        return null;
    }

    @Override
    public void decreaseStock(ProductDTO productDTO) {

    }
}
