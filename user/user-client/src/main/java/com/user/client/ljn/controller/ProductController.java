package com.user.client.ljn.controller;

import com.user.client.ljn.userfeign.UserFeign;
import com.user.server.ljn.entity.SysProductInfo;
import com.user.server.ljn.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    @Autowired
    private UserFeign userFeign;

    @RequestMapping(value = "/product/productList",method = RequestMethod.GET)
    public ModelAndView toProductListPage(Model model){
        //调用商品列表
        List<SysProductInfo> sysProductInfoList = userFeign.getProductList();
        log.info("sysProductInfoList:{}",sysProductInfoList);
        model.addAttribute("sysProductInfoList",sysProductInfoList);
        return new ModelAndView("/product/productList");
    }

    //TODO
    //添加商品类目
    @PostMapping("addCategory")
    public String addCategory(){
        return "";
    }

    //添加商品
    @PostMapping("addProduct")
    public String addProduct(){
        return "";
    }
}
