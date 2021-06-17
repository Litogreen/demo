package com.example.demo.cartms.domain.model.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
public class CartItemPO {

	@Id
	@Column(name = "item_seq", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemSeq;

	@Column(name = "goods_id", nullable = false)
	private String goodsId;

	@Column(name = "count", nullable = false)
	private Integer count;

	@Column(name = "cart_id", nullable = false)
	private String cartId;

	@Column(name = "goods_name", nullable = false)
	private String goodsName;

	@Column(name = "unit_price", nullable = false)
	private Integer unitPrice;

	public String getCartId() {
		return cartId;
	}

	public Integer getCount() {
		return count;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public Integer getItemSeq() {
		return itemSeq;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setItemSeq(Integer itemSeq) {
		this.itemSeq = itemSeq;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

}
