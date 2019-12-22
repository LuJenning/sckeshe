package com.order.server.ljn.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.base.ljn.entity.SysOrderDetail;
import com.order.base.ljn.entity.SysOrderMaster;
import com.order.server.ljn.service.IOrderService;

import com.product.base.ljn.entity.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/create/order",method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestParam("productId") String productId,
                                      @RequestParam("productNum") Integer productNum, HttpServletRequest req){
        log.info("productId，productNum:{},{}",productId,productNum);
        Map<Object,Object> map = new HashMap<>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setProductNum(productNum);
        log.info("productDTO:{}",productDTO);
        if(StringUtils.isNotEmpty(productId) || productNum != null){
            SysOrderMaster sysOrderMaster =  orderService.create(productDTO,req);
            map.put("code",200);
            map.put("信息","下单成功");
            map.put("订单号",sysOrderMaster.getOrderId());
            return new ResponseEntity(map, HttpStatus.OK);
        }else{
            map.put("code",400);
            map.put("信息","下单失败");
        }
        return new ResponseEntity(map, HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/getOrderInfo")
    @HystrixCommand(fallbackMethod = "error")
    public List<SysOrderDetail> showOrderInfo(){
        return orderService.findOrderDetail();
    }



    @RequestMapping(value = "/toCreateOrder",method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "error")
    public ResponseEntity<ProductDTO> toCreateOrder(@RequestBody ProductDTO productDTO,HttpServletRequest req){
        log.info("productDTO:{}",productDTO);
        Map<Object,Object> map = new HashMap<>();
        if(StringUtils.isNotEmpty(productDTO.getProductId()) || productDTO.getProductNum() != null){
            SysOrderMaster sysOrderMaster =  orderService.create(productDTO,req);
            map.put("code",200);
            map.put("信息","下单成功");
            map.put("订单号",sysOrderMaster.getOrderId());
            return new ResponseEntity(map, HttpStatus.OK);
        }else{
            map.put("code",400);
            map.put("信息","下单失败");
        }
        return new ResponseEntity(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public String error(){
        return  "There was a error !!!";
    }
}
