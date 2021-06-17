package com.example.demo.cartms.interfaces.rest.dto;

public class OrderGoodsResDTO {

	private Integer count;
	private String goodsId;
	private String goodsName;
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
