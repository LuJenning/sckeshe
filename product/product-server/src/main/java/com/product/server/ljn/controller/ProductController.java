package com.product.server.ljn.controller;

import com.product.base.ljn.entity.ProductDTO;
import com.product.base.ljn.entity.SysProductCategoryInfo;
import com.product.server.ljn.service.ICategoryService;
import com.product.server.ljn.service.IProductService;
import com.user.common.usercommon.entity.SysProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(value = "/server/productList",method = RequestMethod.GET)
    public List<SysProductInfo> getProductList(){
        return productService.getProductList();
    }

    @RequestMapping(value = "/product/productInfo",method = RequestMethod.GET)
    SysProductInfo getProductInfoNyProductId(@RequestParam("id") String id){
        log.info("sysProductInfo :{}",id);
        return productService.getProductInfoNyProductId(id);
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

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    int addProduct(@RequestBody SysProductInfo sysProductInfo){
        return productService.addProduct(sysProductInfo);
    }

    @RequestMapping(value = "/getCategory",method = RequestMethod.POST)
    List<SysProductCategoryInfo> findCategoryList(){
        return categoryService.findCategoryList();
    }

}