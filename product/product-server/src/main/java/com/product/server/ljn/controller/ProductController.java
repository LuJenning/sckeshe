package com.product.server.ljn.controller;

import com.base.ljn.dto.ProductDTO;
import com.product.base.ljn.entity.SysProductInfo;
import com.product.server.ljn.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping(value = "/server/productList",method = RequestMethod.GET)
    public List<SysProductInfo> getProductList(){
        return productService.getProductList();
    }

    @RequestMapping(value = "/product/list",method = RequestMethod.POST)
    public SysProductInfo getList(@RequestBody ProductDTO productDTO){
        SysProductInfo sysProductInfo = productService.getProduct(productDTO.getProductId());
        return sysProductInfo;
    }

    @RequestMapping(value = "/product/decreaseStock",method = RequestMethod.POST)
    void decreaseStock(@RequestBody ProductDTO productDTO){
        int maxStock = productService.selectStockByProductId(productDTO.getProductId());
        int stock = maxStock - productDTO.getProductNum();
        productService.decreaseStock(stock,productDTO.getProductId());
    }


}