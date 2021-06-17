package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartItemPO;

public class CartItemUpdateDTO {

	public static CartItemUpdateDTO createByCartItemPO(CartItemPO cartItemPO) {
		CartItemUpdateDTO cartItemDTO = new CartItemUpdateDTO();
		BeanUtils.copyProperties( cartItemPO, cartItemDTO );
		return cartItemDTO;
	}

	public static CartItemPO modifyCartItemPO(String cartId, CartItemPO cartItemPO, CartItemUpdateDTO cartItemDTO) {
		BeanUtils.copyProperties( cartItemDTO, cartItemPO );
		cartItemPO.setCartId( cartId );
		return cartItemPO;
	}

	private int count;


	public int getCount() {
		return count;
	}

	public void setCount(int goodsCount) {
		this.count = goodsCount;
	}

}
