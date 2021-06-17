package com.example.demo.cartms.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cartms.application.internal.outboundservices.OrderService;
import com.example.demo.cartms.interfaces.rest.dto.OrderResDTO;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	
	
	@PostMapping("/cart/{cartId}")
	public OrderResDTO createOrder(@PathVariable(name = "cartId")String cartId) {
		return orderService.createOrder( cartId );
	}
}
