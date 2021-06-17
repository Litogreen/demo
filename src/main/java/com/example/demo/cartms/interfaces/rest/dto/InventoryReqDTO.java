package com.example.demo.cartms.interfaces.rest.dto;

public class InventoryReqDTO {
	private String inventory;

	public InventoryReqDTO(String inventory) {
		super();
		this.inventory = inventory;
	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

}
