package com.base.ljn.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

@Data
public class BuyProductDTO implements Serializable {
    //商品id
    private BigInteger productId;
    //所购买的商品数量
    private int productNum;
    //商品描述
    private String productDescription;
    //商品价格
    private BigDecimal productPrice;
    //商品名称
    private String produtName;
    //商品库存
    private int productStock;

    public BigInteger getProductId() {
        return productId;
    }

    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProdutName() {
        return produtName;
    }

    public void setProdutName(String produtName) {
        this.produtName = produtName;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    @Override
    public String toString() {
        return "BuyProductDTO{" +
                "productId=" + productId +
                ", productNum=" + productNum +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", produtName='" + produtName + '\'' +
                ", productStock=" + productStock +
                '}';
    }
}
