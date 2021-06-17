package com.example.demo.cartms.interfaces.rest.dto;

import java.util.Set;
import java.util.stream.Collectors;

public class OrderReqDTO {
	public static OrderReqDTO createOrderByCartDTO(CartDTO cartDTO) {
		OrderReqDTO orderReqDTO = new OrderReqDTO();
		orderReqDTO.setCartId( cartDTO.getCartId() );
		orderReqDTO.setCustomerName( "test" );
		orderReqDTO.setTotalAmount( cartDTO.getAmount() );
		orderReqDTO.setGoods( cartDTO.getCartItemDTO().stream()
				.map( OrderGoodsReqDTO::createOrderGoodsByCartItem )
				.collect( Collectors.toSet() ) );
		return orderReqDTO;
	}

	private String cartId;
	private String customerName;
	private Set<OrderGoodsReqDTO> goods;

	private Integer totalAmount;

	public String getCartId() {
		return cartId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Set<OrderGoodsReqDTO> getGoods() {
		return goods;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setGoods(Set<OrderGoodsReqDTO> goods) {
		this.goods = goods;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

}
