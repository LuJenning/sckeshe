package com.order.server.ljn.service.impl;

import com.order.base.ljn.entity.SysOrderDetail;
import com.order.base.ljn.entity.SysOrderMaster;
import com.order.base.ljn.enums.OrderStatusEnum;
import com.order.base.ljn.enums.PayStatusEnum;
import com.order.base.ljn.utils.KeyUtil;
import com.order.server.ljn.dao.SysOrderDetailMapper;
import com.order.server.ljn.dao.SysOrderMasterMapper;
import com.order.server.ljn.service.IOrderService;

import com.product.base.ljn.entity.ProductDTO;
import com.product.client.ljn.productfeign.feign.ProductClient;
import com.user.common.usercommon.entity.SysProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private SysOrderDetailMapper detailMapper;
    @Autowired
    private SysOrderMasterMapper masterMapper;
    @Autowired
    private ProductClient productClient;

    @Override
    public void saveDetail(SysOrderDetail orderDetail) {
        detailMapper.save(orderDetail);
    }

    @Override
    public void saveOrderMaster(SysOrderMaster orderMaster) {
        masterMapper.saveMaster(orderMaster);
    }

    @Override
    public SysOrderMaster create(ProductDTO productDTO, HttpServletRequest req) {
        String orderId = KeyUtil.genUniqueKey();
        //调用商品服务查询出商品
        SysProductInfo sysProductInfo = productClient.getList(productDTO);
        //计算总价
        BigDecimal orderAmout = new BigDecimal(BigInteger.ZERO);
        orderAmout =  sysProductInfo.getProductPrice()
                    .multiply(new BigDecimal(productDTO.getProductNum()))
                    .add(orderAmout);
            //订单详情入库
        SysOrderDetail orderDetail = new SysOrderDetail();
        orderDetail.setOrderId(orderId);
        orderDetail.setDetailId(KeyUtil.genUniqueKey());
        orderDetail.setProductId(productDTO.getProductId());
        orderDetail.setProductName(sysProductInfo.getProductName());
        orderDetail.setProductPrice(orderAmout);
        orderDetail.setProductQuantity(productDTO.getProductNum());
        detailMapper.save(orderDetail);
        //扣库存
        productClient.decreaseStock(productDTO);
        //SysUserInfo sysUserInfo = (SysUserInfo) req.getSession().getAttribute("sysUserInfo");
        //订单入库
        SysOrderMaster orderMaster = new SysOrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        //orderMaster.setBuyerId(sysUserInfo.getId());
        masterMapper.saveMaster(orderMaster);
        return orderMaster;
    }

    @Override
    public List<SysOrderDetail> findOrderDetail() {
        return detailMapper.findOrderDetail();
    }
}
