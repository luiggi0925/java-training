package edu.globant.day1.multi_tier_applications.exercices.structure.controllers;

import edu.globant.day1.multi_tier_applications.exercices.structure.services.InventoryService;

public class InventoryController {
	private InventoryService inventoryService;

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
}
