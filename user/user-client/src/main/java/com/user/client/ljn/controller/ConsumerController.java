package com.user.client.ljn.controller;

import com.base.ljn.dto.ProductDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.base.ljn.entity.SysOrderDetail;
import com.user.client.ljn.common.RibbonCommon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate ;

    @RequestMapping("/showOrderInfo")
    public List<SysOrderDetail> showOrderInfo(){
        List<SysOrderDetail> sysOrderDetailList = restTemplate.getForObject(RibbonCommon.ORDER_SERVER + "/getOrderInfo",List.class);
        return sysOrderDetailList;
    }


    @RequestMapping(value = "/create/order",method = RequestMethod.POST)
    public ResponseEntity<ProductDTO> createOrder(@RequestParam("productId") String productId,
                                      @RequestParam("productNum") Integer productNum, HttpServletRequest req) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductNum(productNum);
            productDTO.setProductId(productId);
            ResponseEntity<ProductDTO> responseEntity = restTemplate.postForEntity(RibbonCommon.ORDER_SERVER + "/toCreateOrder",productDTO,ProductDTO.class);
            log.info("responseEntity:{}",responseEntity);
            Map<Object,Object> map = new HashMap<>();
            map.put("code",200);
            map.put("msg","成功");
            return new ResponseEntity(map,HttpStatus.OK);
        }
    }
