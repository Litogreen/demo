package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

import lombok.Data;

@Data
public class GoodsResDTO {

	public static GoodsResDTO createOrderByCartItem(CartItemDTO cartItemDTO) {
		GoodsResDTO goodsResDTO = new GoodsResDTO();
		BeanUtils.copyProperties( cartItemDTO, goodsResDTO );
		return goodsResDTO;
	}

	private String goodsId;
	private String goodsName;
	private Integer inventory;
	private Integer unitPrice;

}
