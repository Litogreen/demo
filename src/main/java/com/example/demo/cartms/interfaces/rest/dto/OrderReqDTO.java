package com.example.demo.cartms.interfaces.rest.dto;

import java.util.Set;
import java.util.stream.Collectors;

import lombok.Data;

@Data
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


}
