package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class OrderGoodsReqDTO {

	public static OrderGoodsReqDTO createOrderGoodsByCartItem(CartItemDTO cartItemDTO) {
		OrderGoodsReqDTO goodsResDTO = new OrderGoodsReqDTO();
		BeanUtils.copyProperties( cartItemDTO, goodsResDTO );
		return goodsResDTO;
	}

	private String goodsId;
	private String goodsName;
	private Integer count;
	private Boolean udpated = false;
	private Integer unitPrice;

}
