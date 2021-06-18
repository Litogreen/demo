package com.example.demo.cartms.interfaces.rest.dto;

import lombok.Data;

@Data
public class OrderGoodsResDTO {

	private Integer count;
	private String goodsId;
	private String goodsName;
	private Integer unitPrice;

}
