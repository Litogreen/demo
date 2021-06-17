package com.example.demo.cartms.application.internal.outboundservices;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.cartms.interfaces.rest.dto.GoodsResDTO;
import com.example.demo.cartms.interfaces.rest.dto.InventoryReqDTO;

@Service
public class GoodsService {

	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds( 60 );
	@Autowired
	private WebClient goodsApiClient;

	public GoodsResDTO getGoodsById(String goodsId) {
		return goodsApiClient.get()
				.uri( "/goods/" + goodsId )
				.retrieve()
				.bodyToMono( GoodsResDTO.class )
				.block( REQUEST_TIMEOUT );
	}

	public GoodsResDTO updateGoodsInventory(String goodsId, Integer inventory) {
		
		return goodsApiClient.patch()
				.uri( "/goods/" + goodsId + "/inventory" )
				.contentType( MediaType.APPLICATION_JSON )
				.bodyValue( new InventoryReqDTO( inventory.toString() ) )
				.retrieve()
				.bodyToMono( GoodsResDTO.class )
				.block( REQUEST_TIMEOUT );
	}
}
