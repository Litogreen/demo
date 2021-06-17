package com.example.demo.cartms.interfaces.rest.dto;

import java.util.Set;

public class OrderResDTO {
	
	private String customerName;
	private Set<OrderGoodsResDTO> goods;
	private String orderId;

	private Integer totalAmount;

	public String getCustomerName() {
		return customerName;
	}

	public Set<OrderGoodsResDTO> getGoods() {
		return goods;
	}

	public String getOrderId() {
		return orderId;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setGoods(Set<OrderGoodsResDTO> goods) {
		this.goods = goods;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
}
