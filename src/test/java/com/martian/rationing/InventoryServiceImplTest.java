/**
 * 
 */
package com.martian.rationing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.martian.rationing.model.Inventory;
import com.martian.rationing.model.Ration;
import com.martian.rationing.model.Water;
import com.martian.rationing.repository.InventoryRepository;
import com.martian.rationing.service.impl.InventoryServiceImpl;


/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class InventoryServiceImplTest {

	@MockBean 
	private InventoryRepository inventoryRepository;
	
	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSaveInventory() {
		Ration rationOne = new Ration();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("28-01-2020");
		rationOne.setStatus(true);
		
		Ration rationTwo = new Ration();
		rationTwo.setId(2l);
		rationTwo.setPacketId("F2");
		rationTwo.setPacketType("Food");
		rationTwo.setPacketContent("Protien Bar");
		rationTwo.setCalories(1500);
		rationTwo.setExpiryDate("30-01-2020");
		rationTwo.setStatus(true);
		
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		
		List<Ration> rationList = new ArrayList<Ration>();
		List<Water> waterList = new ArrayList<Water>();
		rationList.add(rationOne);
		rationList.add(rationTwo);
		waterList.add(water);
		
		Inventory inventory = new Inventory();
		inventory.setDate("2020-01-16");
		inventory.setId(1l);
		inventory.setRationList(rationList);
		inventory.setWaterList(waterList);
		
		when(inventoryRepository.save(Mockito.any(Inventory.class))).thenReturn(inventory);
		Inventory saveInventory = inventoryServiceImpl.saveInventory(inventory);
		assertEquals(inventory.getId(),saveInventory.getId());

	}
	
	@Test
	void testGetAllInventoryData() {
		Ration rationOne = new Ration();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("2020-01-28");
		rationOne.setStatus(true);
	
		Ration rationTwo = new Ration();
		rationTwo.setId(2l);
		rationTwo.setPacketId("F2");
		rationTwo.setPacketType("Food");
		rationTwo.setPacketContent("Protien Bar");
		rationTwo.setCalories(1500);
		rationTwo.setExpiryDate("30-01-2020");
		rationTwo.setStatus(true);
		
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		
		List<Ration> rationList = new ArrayList<Ration>();
		List<Water> waterList = new ArrayList<Water>();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		rationList.add(rationOne);
		rationList.add(rationTwo);
		waterList.add(water);
		
		Inventory inventory = new Inventory();
		inventory.setDate("2020-02-16");
		inventory.setId(1l);
		inventory.setRationList(rationList);
		inventory.setWaterList(waterList);
		inventoryList.add(inventory);
		
		when(inventoryRepository.findAllInventoryByDateAsc()).thenReturn(inventoryList);
		List<Inventory> fatchInventoryList = inventoryServiceImpl.getAllInventoryData();
		assertEquals(inventoryList.get(0).getId(),fatchInventoryList.get(0).getId());
		
	}

}
