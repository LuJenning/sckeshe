package com.base.ljn.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigInteger;

@Data
public class ProductDTO implements Serializable {
    private Integer productNum;
    private String productId;

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productNum=" + productNum +
                ", productId=" + productId +
                '}';
    }
}
