package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartItemPO;

import lombok.Data;

@Data
public class CartItemDTO {

	public static CartItemDTO createByCartItemPO(CartItemPO cartItemPO) {
		CartItemDTO cartItemDTO = new CartItemDTO();
		BeanUtils.copyProperties( cartItemPO, cartItemDTO );
		return cartItemDTO;
	}

	public static CartItemPO createCartItemPO(String cartId, CartItemDTO cartItemDTO) {
		CartItemPO cartItemPO = new CartItemPO();
		BeanUtils.copyProperties( cartItemDTO, cartItemPO );
		cartItemPO.setCartId( cartId );
		return cartItemPO;
	}

	private String goodsId;

	private String goodsName;

	private Integer unitPrice;

	private Integer count;


}
