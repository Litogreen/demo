package com.example.demo.cartms.interfaces.rest.dto;

import static java.util.stream.Collectors.toSet;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;

import com.example.demo.cartms.domain.model.entites.CartPO;

public class CartDTO {

	public static CartDTO createByCartPO(CartPO cartPO) {
		CartDTO cartDTO = new CartDTO();
		BeanUtils.copyProperties( cartPO, cartDTO );
		cartDTO.setCartItemDTO( Stream.of( cartPO.getCartItemPO() )
				.flatMap( Collection::stream )
				.map( CartItemDTO::createByCartItemPO )
				.collect( toSet() ) );
		return cartDTO;
	}
	
	public static CartPO createCartPO(CartDTO cartDTO) {
		CartPO cartPO = new CartPO();
		BeanUtils.copyProperties( cartDTO, cartPO );
		return cartPO;
	}

	private String cartId;
	private int amount;
	private LocalDateTime createdDate;
	private LocalDateTime lastModifiedDate;
	private Set<CartItemDTO> cartItemDTO;

	public int getAmount() {
		return amount;
	}

	public String getCartId() {
		return cartId;
	}

	public Set<CartItemDTO> getCartItemDTO() {
		return cartItemDTO;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public void setCartItemDTO(Set<CartItemDTO> cartItemDTO) {
		this.cartItemDTO = cartItemDTO;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
