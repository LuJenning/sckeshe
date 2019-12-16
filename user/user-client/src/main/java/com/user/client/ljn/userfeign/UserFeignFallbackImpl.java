package com.user.client.ljn.userfeign;

import com.base.ljn.dto.ProductDTO;
import com.user.common.usercommon.entity.SysProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class UserFeignFallbackImpl implements UserFeign {

    @Override
    public List<SysProductInfo> getProductList() {
        log.info("服务器开小差....");
        return null;
    }

    @Override
    public void createProduct(ProductDTO productDTO) {
        log.info("服务器开小差....");
    }

    @Override
    public SysProductInfo getProductInfoNyProductId(String id) {
        log.info("服务器开小差....");
        return null;
    }

}
