package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

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

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public Integer getInventory() {
		return inventory;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
}
