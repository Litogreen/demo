package com.example.demo.cartms.interfaces.rest.dto;

import java.util.Set;

import lombok.Data;

@Data
public class OrderResDTO {
	
	private String customerName;
	private Set<OrderGoodsResDTO> goods;
	private String orderId;

	private Integer totalAmount;

}
