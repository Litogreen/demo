package com.example.demo.cartms.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.cartms.application.internal.outboundservices.GoodsService;
import com.example.demo.cartms.interfaces.rest.dto.GoodsResDTO;

@RestController
@RequestMapping("/goods")
public class GoodsTestController {

	@Autowired
	GoodsService goodsService;

	@GetMapping(path = "/{goodsId}")
	public GoodsResDTO testGetGoodsInfo(
			@PathVariable(value = "goodsId", required = false) String goodsId) {
		return goodsService.getGoodsById( goodsId );
	}
}
