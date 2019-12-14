package com.product.base.ljn.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class DecreaseStockInput implements Serializable {
    private String productId;
    private Integer productNum;
}
