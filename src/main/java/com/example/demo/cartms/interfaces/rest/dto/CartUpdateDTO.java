package com.example.demo.cartms.interfaces.rest.dto;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartPO;

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

	public Integer getAmount() {
		return amount;
	}

	public Set<CartItemUpdateDTO> getCartItemUpdateDTO() {
		return cartItemUpdateDTO;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCartItemUpdateDTO(Set<CartItemUpdateDTO> cartItemUpdateDTO) {
		this.cartItemUpdateDTO = cartItemUpdateDTO;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
