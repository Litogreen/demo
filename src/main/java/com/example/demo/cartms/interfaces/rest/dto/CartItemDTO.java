package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartItemPO;

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

	public Integer getCount() {
		return count;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}


	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

}
