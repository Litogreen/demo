package com.example.demo.cartms.interfaces.rest.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartPO;

import lombok.Data;

@Data
public class CartUpdateDTO {

	public static CartUpdateDTO createByCartPO(CartPO cartPO) {
		CartUpdateDTO cartUpdateDTO = new CartUpdateDTO();
		BeanUtils.copyProperties( cartPO, cartUpdateDTO );
		return cartUpdateDTO;
	}

	public static CartPO modifyCartPO(CartDTO cartDTO, CartUpdateDTO cartUpdateDTO) {
		CartPO cartPO = new CartPO();
		BeanUtils.copyProperties( cartUpdateDTO, cartPO );
		return cartPO;
	}

	private Integer amount;

	private LocalDateTime lastModifiedDate;

	private Set<CartItemUpdateDTO> cartItemUpdateDTO;


}
