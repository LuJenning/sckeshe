package com.user.client.ljn.controller;

import com.alibaba.fastjson.JSONObject;
import com.base.ljn.utils.FileUtils;
import com.order.base.ljn.utils.KeyUtil;
import com.user.client.ljn.userfeign.UserFeign;
import com.user.common.usercommon.entity.SysProductInfo;
import com.user.server.ljn.entity.SysProductCategoryInfo;
import com.user.server.ljn.service.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.*;

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

    @RequestMapping(value = "/product/productInfo",method = RequestMethod.GET)
    public ModelAndView productInfo(HttpServletRequest req,Model model){
        String id = req.getParameter("id");
        log.info("id:{}",id);
        SysProductInfo sysProductInfo2 = userFeign.getProductInfoNyProductId(id);
        log.info("sysProductInfo 35 line:{}",sysProductInfo2);
        model.addAttribute("sysProductInfo",sysProductInfo2);
        return new ModelAndView("/product/productDetail");
    }
    //TODO
    //添加商品类目
    @GetMapping("/product/addCategory")
    public ModelAndView addCategoryPage(){
        return new ModelAndView("/category/categoryAdd");
    }

    //添加商品页面
    @GetMapping("/product/addProduct")
    public ModelAndView addProductPage(ModelMap model){
        List<SysProductCategoryInfo> list = userFeign.findCategoryList();
        model.addAttribute("list",list);
        return new ModelAndView("product/productAdd");
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Map<Object,Object> addProduct(@RequestParam("file") MultipartFile file, @RequestParam(value = "productName",required = false) String productName, @RequestParam(value = "productDescription",required = false) String productDescription, @RequestParam(value = "productPrice",required = false) BigDecimal productPrice,
                                         @RequestParam(value = "productStock",required = false) Integer productStock, @RequestParam(value = "categoryType",required = false) Integer categoryType, @RequestParam("productIcon") String productIcon, Map<Object,Object> map,HttpServletRequest req){
        SysProductInfo sysProductInfo = new SysProductInfo();
        sysProductInfo.setProductId(KeyUtil.genUniqueKey());
        sysProductInfo.setProductName(productName);
        sysProductInfo.setProductPrice(productPrice);
        sysProductInfo.setProductDescription(productDescription);
        sysProductInfo.setProductStock(productStock);
        sysProductInfo.setCategoryType(categoryType);
        sysProductInfo.setProductStatus((byte) 1);
        sysProductInfo.setProductIcon(productIcon);
        log.info("SysProductInfo:{}",sysProductInfo);
        int i = userFeign.addProduct(sysProductInfo);
        if(i > 0){
            map.put("code",200);
            map.put("msg","添加成功");
        }else {
            map.put("code", 500);
            map.put("msg", "添加失败");
        }
        return map;
    }

    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject uploadImg(@RequestParam("file") MultipartFile file) throws Exception {
        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        log.info("suffixName:{}",suffixName);
        // 构造新的文件名
        String fileName = UUID.randomUUID().toString().replace("-","") + suffixName;
        log.info("fileName:{}",fileName);
        String os = System.getProperty("os.name");
        String filePath = "";
        if (os.toLowerCase().startsWith("win")) {
            //windows下的路径
            filePath = "E:\\sckeshe\\user\\user-client\\src\\main\\resources\\upload\\";
        } else {
            //linux下的路径
            filePath = "/root/pictureUpload/project/";
        }
        Boolean writePictureflag = FileUtils.uploadFile(file.getBytes(), filePath, fileName);
        if (writePictureflag == false) {
            log.info("炸了");
        }
        String fullImgpath = filePath + fileName;
        log.info("fullImgpath:{}",fullImgpath);
        resUrl.put("data",fullImgpath);
        res.put("msg","");
        res.put("code",0);
        res.put("data",resUrl);
        return res;
        }
}
