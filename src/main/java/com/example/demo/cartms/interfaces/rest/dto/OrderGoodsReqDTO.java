package com.example.demo.cartms.interfaces.rest.dto;

import org.springframework.beans.BeanUtils;

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

	public Integer getCount() {
		return count;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public Boolean getUdpated() {
		return udpated;
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

	public void setUdpated(Boolean udpated) {
		this.udpated = udpated;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
}
