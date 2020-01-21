package com.martian.rationing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.martian.rationing.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
	
	/**
	 * query for find all Inventory by ascending on date
	 * 
	 * @return inventory list
	 */
	@Query("Select r from Inventory as r order by r.date")
	List<Inventory> findAllInventoryByDateAsc();

}
