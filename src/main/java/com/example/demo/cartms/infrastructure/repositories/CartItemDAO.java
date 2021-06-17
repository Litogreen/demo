package com.example.demo.cartms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cartms.domain.model.entites.CartItemPO;

public interface CartItemDAO extends JpaRepository<CartItemPO, String> {

}
