package com.example.demo.cartms.application.internal.outboundservices;

import static com.example.demo.exceptions.DemoResponseConst.ReturnCode.E0001;

import java.time.LocalDateTime;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cartms.domain.model.entites.CartItemPO;
import com.example.demo.cartms.domain.model.entites.CartPO;
import com.example.demo.cartms.infrastructure.repositories.CartDAO;
import com.example.demo.cartms.infrastructure.repositories.CartItemDAO;
import com.example.demo.cartms.interfaces.rest.dto.CartDTO;
import com.example.demo.cartms.interfaces.rest.dto.CartItemDTO;
import com.example.demo.cartms.interfaces.rest.dto.CartItemUpdateDTO;
import com.example.demo.exceptions.DemoException;

@Service
public class CartService {

	@Autowired
	CartDAO cartDAO;

	@Autowired
	CartItemDAO cartItemDAO;

	@Transactional
	public CartDTO addItemToCart(String cartId, CartItemDTO cartItemDTO) {
		CartPO cartPO = cartDAO.getById( cartId );
		CartItemPO cartItemPO = CartItemDTO.createCartItemPO( cartId, cartItemDTO );
		cartItemDAO.save( cartItemPO );
		cartPO.getCartItemPO().add( cartItemPO );
		int total = 0;
		total = cartPO.getCartItemPO().stream()
				.mapToInt( p -> p.getCount() * p.getUnitPrice() )
				.sum();
		cartPO.setAmount( total );
		return CartDTO.createByCartPO( cartPO );
	}

	@Transactional
	public CartDTO createCart() {
		CartPO cartPO = new CartPO( 0, LocalDateTime.now(), LocalDateTime.now() );
		cartPO.setCartItemPO( new HashSet<CartItemPO>() );
		cartDAO.save( cartPO );
		return CartDTO.createByCartPO( cartPO );
	}

	@Transactional
	public void deleteCart(String cartId) {
		cartDAO.deleteById( cartId );
	}

	@Transactional
	public CartDTO deleteItemFromCart(String cartId, String goodsId) {
		CartPO cartPO = cartDAO.getById( cartId );
		cartPO.setLastModifiedDate( LocalDateTime.now() );
		cartPO.getCartItemPO().stream().findFirst().ifPresent( p -> cartItemDAO.delete( p ) );
		cartPO.getCartItemPO().removeIf( p -> p.getGoodsId().equals( goodsId ) );
		int total = 0;
		total = cartPO.getCartItemPO().stream()
				.mapToInt( p -> p.getCount() * p.getUnitPrice() )
				.sum();
		cartPO.setAmount( total );
		return CartDTO.createByCartPO( cartPO );
	}

	@Transactional
	public CartDTO editCartGoods(String cartId, String goodsId,
			CartItemUpdateDTO cartItemUpdateDTO) {
		CartPO cartPO = cartDAO.getById( cartId );
		cartPO.setLastModifiedDate( LocalDateTime.now() );
		int total = 0;
		cartPO.getCartItemPO().stream()
				.filter( g -> g.getGoodsId().equals( goodsId ) )
				.findAny()
				.ifPresent( g -> {
					g.setCount( cartItemUpdateDTO.getCount() );
				} );
		total = cartPO.getCartItemPO().stream()
				.mapToInt( p -> p.getCount() * p.getUnitPrice() )
				.sum();
		cartPO.setAmount( total );
		return CartDTO.createByCartPO( cartPO );
	}

	public CartDTO getCart(String cartId) {
		CartDTO cartDTO = new CartDTO();
		CartPO cartPO = cartDAO.findById( cartId )
				.orElseThrow( () -> DemoException.createByCodeAndExtInfo( E0001, "無此購物車" ) );
		cartDTO = CartDTO.createByCartPO( cartPO );
		return cartDTO;
	}
}
