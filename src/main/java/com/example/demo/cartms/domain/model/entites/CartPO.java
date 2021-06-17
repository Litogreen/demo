package com.example.demo.cartms.domain.model.entites;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "cart")
public class CartPO {

	@Column(name = "amount", nullable = false, length = 50)
	private Integer amount;

	@Column(name = "last_modified_date", unique = true, nullable = false, length = 50)
	private LocalDateTime lastModifiedDate;

	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	@Id
	@Column(name = "cart_id", nullable = false)
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String cartId;

	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cart_id")
	private Set<CartItemPO> cartItemPO;

	public CartPO() {
		super();
	}

	public CartPO(Integer amount, LocalDateTime lastModifiedDate, LocalDateTime createdDate) {
		super();
		this.amount = amount;
		this.lastModifiedDate = lastModifiedDate;
		this.createdDate = createdDate;
	}

	public Integer getAmount() {
		return amount;
	}

	public String getCartId() {
		return cartId;
	}

	public Set<CartItemPO> getCartItemPO() {
		return cartItemPO;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public void setCartItemPO(Set<CartItemPO> cartItemPO) {
		this.cartItemPO = cartItemPO;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
