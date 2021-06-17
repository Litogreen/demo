package com.example.demo.cartms.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.cartms.domain.model.entites.CartPO;

public interface CartDAO extends JpaRepository<CartPO, String> {

}
