package com.product.client.ljn.productfeign.fallback;

import com.base.ljn.dto.BuyProductDTO;
import com.base.ljn.dto.ProductDTO;
import com.product.client.ljn.productfeign.feign.ProductClient;
import com.user.common.usercommon.entity.SysProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductClientFallback implements ProductClient {


    @Override
    public void createOrderFor(BuyProductDTO buyProductDTO) {
        log.info("服务器开小差....");
    }

    @Override
    public SysProductInfo getList(ProductDTO productDTO) {
        SysProductInfo sysProductInfo = new SysProductInfo();
        log.info("服务器开小差....");
        return sysProductInfo;
    }

    @Override
    public void decreaseStock(ProductDTO productDTO) {
        log.info("服务器开小差....");
    }
}
