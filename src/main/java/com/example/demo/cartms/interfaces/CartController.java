package com.example.demo.cartms.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cartms.application.internal.outboundservices.CartService;
import com.example.demo.cartms.interfaces.rest.dto.CartDTO;
import com.example.demo.cartms.interfaces.rest.dto.CartItemDTO;
import com.example.demo.cartms.interfaces.rest.dto.CartItemUpdateDTO;

@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@PostMapping(path = "/{cartId}")
	public CartDTO addCart(@PathVariable(value = "cartId", required = false) String cartId,
			@RequestBody CartItemDTO cartItemDTO) {
		return cartService.addItemToCart( cartId, cartItemDTO );
	}

	@PostMapping
	public CartDTO createCart() {
		return cartService.createCart();
	}

	@DeleteMapping(path = "/{cartId}")
	public void deleteCart(@PathVariable("cartId") String cartId) {
		cartService.deleteCart( cartId );
	}

	@PutMapping(path = "/{cartId}/goodsId/{goodsId}")
	public CartDTO editCartGoods(@PathVariable("cartId") String cartId,
			@PathVariable("goodsId") String goodsId,
			@RequestBody CartItemUpdateDTO updateCartItemDTO) {
		return cartService.editCartGoods( cartId, goodsId, updateCartItemDTO );
	}

	@GetMapping(path = "/{cartId}")
	public CartDTO getCartById(
			@PathVariable(value = "cartId", required = false) String cartId) {
		return cartService.getCart( cartId );
	}

}
