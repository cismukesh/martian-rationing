/**
 * 
 */
package com.martian.rationing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.martian.rationing.controller.InventoryController;
import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.service.InventoryService;
import com.martian.rationing.service.RationService;
import com.martian.rationing.service.WaterService;


/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class InventoryControllerTest {

	@MockBean
	private InventoryService inventoryService;
	
	@MockBean
	private RationService rationService;
	
	@MockBean
	private WaterService waterService;
	
	@Autowired 
	private InventoryController inventoryController;
	
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
	void testScheduleInventory() throws ParseException {
		RationDTO rationOne = new RationDTO();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("2020-01-29");
		rationOne.setStatus(true);
		
		RationDTO rationTwo = new RationDTO();
		rationTwo.setId(2l);
		rationTwo.setPacketId("F2");
		rationTwo.setPacketType("Food");
		rationTwo.setPacketContent("Protien Bar");
		rationTwo.setCalories(1500);
		rationTwo.setExpiryDate("2020-01-30");
		rationTwo.setStatus(true);
		
		WaterDTO water = new WaterDTO();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		
		List<RationDTO> rationList = new ArrayList<RationDTO>();
		List<WaterDTO> waterList = new ArrayList<WaterDTO>();
		rationList.add(rationOne);
		rationList.add(rationTwo);
		waterList.add(water);
		
		when(waterService.getAllWater()).thenReturn(waterList);
		when(rationService.getAllRation()).thenReturn(rationList);
		
		ModelAndView response = inventoryController.createSchedule();
		assertEquals("viewschedule",response.getViewName());
	}

}
