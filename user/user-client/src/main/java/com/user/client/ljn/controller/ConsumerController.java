package com.user.client.ljn.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.order.base.ljn.entity.SysOrderDetail;
import com.user.client.ljn.common.RibbonCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate ;

    @RequestMapping("/showOrderInfo")
    public List<SysOrderDetail> showOrderInfo(){
        List<SysOrderDetail> sysOrderDetailList = restTemplate.getForObject(RibbonCommon.ORDER_SERVER + "/getOrderInfo",List.class);
        return sysOrderDetailList;
    }


}
