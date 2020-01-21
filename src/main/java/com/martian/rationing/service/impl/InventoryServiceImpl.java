package com.martian.rationing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martian.rationing.model.Inventory;
import com.martian.rationing.repository.InventoryRepository;
import com.martian.rationing.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository inventoryRepository;
	
	/**
	 * method implementation for save inventory ration 
	 */
	@Override
	public Inventory saveInventory(Inventory inventory) {
		return inventoryRepository.save(inventory);
	}

	/**
	 * method implementation for get list of all inventory data
	 */
	@Override
	public List<Inventory> getAllInventoryData() {
		return inventoryRepository.findAllInventoryByDateAsc();
	}

	@Override
	public void deleteAllInventoryData() {
		inventoryRepository.deleteAll();
	}
}
