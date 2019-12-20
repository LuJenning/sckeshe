package com.product.client.ljn.productfeign.feign;

import com.product.base.ljn.entity.BuyProductDTO;
import com.product.base.ljn.entity.ProductDTO;
import com.product.client.ljn.productfeign.fallback.ProductClientFallback;
import com.user.common.usercommon.entity.SysProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "scproduct",fallback = ProductClientFallback.class)
public interface ProductClient {

    @RequestMapping(value = "/product/buy",method = RequestMethod.POST)
    void createOrderFor(@RequestBody BuyProductDTO buyProductDTO);

    @RequestMapping(value = "/product/list",method = RequestMethod.POST)
    SysProductInfo getList(@RequestBody ProductDTO productDTO);

    @RequestMapping(value = "/product/decreaseStock",method = RequestMethod.POST)
    void decreaseStock(@RequestBody ProductDTO productDTO);
}
