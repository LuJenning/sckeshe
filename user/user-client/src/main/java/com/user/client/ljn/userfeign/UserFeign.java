package com.user.client.ljn.userfeign;

import com.base.ljn.dto.ProductDTO;
import com.user.common.usercommon.entity.SysProductInfo;
import com.user.server.ljn.entity.SysProductCategoryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "scproduct",fallback = UserFeignFallbackImpl.class)
public interface UserFeign {

    @RequestMapping(value = "/server/productList",method = RequestMethod.GET)
    List<SysProductInfo> getProductList();

    @RequestMapping(value = "/product/buy",method = RequestMethod.POST)
    void createProduct(@RequestBody ProductDTO productDTO);

    @RequestMapping(value = "/product/productInfo",method = RequestMethod.GET)
    SysProductInfo getProductInfoNyProductId(@RequestParam("id") String id);

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    int addProduct(@RequestBody SysProductInfo sysProductInfo);

    @RequestMapping(value = "/getCategory",method = RequestMethod.POST)
    List<SysProductCategoryInfo> findCategoryList();
}
