package com.order.server.ljn.service;

import com.base.ljn.dto.ProductDTO;
import com.order.base.ljn.entity.SysOrderDetail;
import com.order.base.ljn.entity.SysOrderMaster;

public interface IOrderService {
    //保存订单详情
    void saveDetail(SysOrderDetail orderDetail);
    //保存订单主内容
    void saveOrderMaster(SysOrderMaster orderMaster);
    //创建订单
    void create(ProductDTO productDTO);
}
