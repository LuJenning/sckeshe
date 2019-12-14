package com.order.server.ljn.controller;

import com.base.ljn.dto.ProductDTO;
import com.order.server.ljn.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping(value = "/create/order",method = RequestMethod.POST)
    public Map<Object,Object> createOrder(@RequestParam("productId") String productId,
                                          @RequestParam("productNum") Integer productNum){
        log.info("productId，productNum:{},{}",productId,productNum);
        Map<Object,Object> map = new HashMap<>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setProductNum(productNum);
        log.info("productDTO:{}",productDTO);
        if(StringUtils.isNotEmpty(productId) || productNum != null){
            orderService.create(productDTO);
        }else{

        }
        map.put("code",200);
        map.put("信息","下单成功");
        map.put("订单号",productDTO.getProductId());
        return map;
    }
}
