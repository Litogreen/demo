package com.example.demo.cartms.application.internal.outboundservices;

import java.time.Duration;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.cartms.interfaces.rest.dto.CartDTO;
import com.example.demo.cartms.interfaces.rest.dto.GoodsResDTO;
import com.example.demo.cartms.interfaces.rest.dto.OrderGoodsReqDTO;
import com.example.demo.cartms.interfaces.rest.dto.OrderReqDTO;
import com.example.demo.cartms.interfaces.rest.dto.OrderResDTO;

@Service
public class OrderService {

	private static Logger LOGGER = LogManager.getLogger( OrderService.class );
	private static final Duration REQUEST_TIMEOUT = Duration.ofSeconds( 60 );
	@Autowired
	private WebClient orderApiClient;

	@Autowired
	private CartService cartService;

	@Autowired
	private GoodsService goodsService;

	public OrderResDTO createOrder(String cartId) {
		CartDTO cartDTO = cartService.getCart( cartId );

		OrderReqDTO orderReqDTO = OrderReqDTO.createOrderByCartDTO( cartDTO );
		try {
			orderReqDTO.getGoods().stream()
					.forEach( (OrderGoodsReqDTO orderGoods) -> {
						GoodsResDTO goodsInfo =
								goodsService.getGoodsById( orderGoods.getGoodsId() );

						LOGGER.info( "goodsInfo: " +
								ReflectionToStringBuilder.toString( goodsInfo ) );
						LOGGER.info( "orderGoods: " +
								ReflectionToStringBuilder.toString( orderGoods ) );
						GoodsResDTO goodsResDTO =
								goodsService.updateGoodsInventory( orderGoods.getGoodsId(),
										goodsInfo.getInventory() - orderGoods.getCount() );

						LOGGER.info( "goodsResDTO: "
								+ ReflectionToStringBuilder.toString( goodsResDTO ) );
						orderGoods.setUdpated( true );
					} );
			
			 OrderResDTO orderResDTO = orderApiClient.post()
					.uri( "/orders" )
					.contentType( MediaType.APPLICATION_JSON )
					.bodyValue( orderReqDTO )
					.retrieve()
					.bodyToMono( OrderResDTO.class )
					.block( REQUEST_TIMEOUT );
			 
			 return orderResDTO;
		} catch (Exception ex) {
			orderReqDTO.getGoods().stream()
					.filter( OrderGoodsReqDTO::getUdpated )
					.forEach( (OrderGoodsReqDTO orderGoods) -> {
						GoodsResDTO goodsInfo =
								goodsService.getGoodsById( orderGoods.getGoodsId() );
						goodsService.updateGoodsInventory( orderGoods.getGoodsId(),
								goodsInfo.getInventory() + orderGoods.getCount() );
						orderGoods.setUdpated( false );
					} );
			throw ex;
		}

	}
}
