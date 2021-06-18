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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("購物車管理")
@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	CartService cartService;

	@ApiOperation("新增商品到購物車")
	@PostMapping(path = "/{cartId}")
	public CartDTO addCart(@PathVariable(value = "cartId", required = false) String cartId,
			@RequestBody CartItemDTO cartItemDTO) {
		return cartService.addItemToCart( cartId, cartItemDTO );
	}

	@ApiOperation("建立購物車")
	@PostMapping
	public CartDTO createCart() {
		return cartService.createCart();
	}

	@ApiOperation("刪除購物車")
	@DeleteMapping(path = "/{cartId}")
	public void deleteCart(@PathVariable("cartId") String cartId) {
		cartService.deleteCart( cartId );
	}

	@ApiOperation("修改購物車商品")
	@PutMapping(path = "/{cartId}/goodsId/{goodsId}")
	public CartDTO editCartGoods(@PathVariable("cartId") String cartId,
			@PathVariable("goodsId") String goodsId,
			@RequestBody CartItemUpdateDTO updateCartItemDTO) {
		return cartService.editCartGoods( cartId, goodsId, updateCartItemDTO );
	}

	@ApiOperation("查詢購物車")
	@GetMapping(path = "/{cartId}")
	public CartDTO getCartById(
			@PathVariable(value = "cartId", required = false) String cartId) {
		return cartService.getCart( cartId );
	}

}
