package com.martian.rationing.service;

import java.util.List;

import com.martian.rationing.model.Inventory;

public interface InventoryService {

	Inventory saveInventory(Inventory inventory);
	
	List<Inventory> getAllInventoryData();
	
	void deleteAllInventoryData();
}
