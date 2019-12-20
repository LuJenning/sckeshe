package com.order.server.ljn.service;

import com.order.base.ljn.entity.SysOrderDetail;
import com.order.base.ljn.entity.SysOrderMaster;
import com.product.base.ljn.entity.ProductDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IOrderService {
    //保存订单详情
    void saveDetail(SysOrderDetail orderDetail);
    //保存订单主内容
    void saveOrderMaster(SysOrderMaster orderMaster);
    //创建订单
    SysOrderMaster create(ProductDTO productDTO, HttpServletRequest req);

    List<SysOrderDetail> findOrderDetail();
}
