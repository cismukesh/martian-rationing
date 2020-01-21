/**
 * 
 */
package com.martian.rationing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.model.Water;
import com.martian.rationing.repository.WaterRepository;
import com.martian.rationing.service.impl.WaterServiceImpl;


/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class WaterServiceImplTest {

	@MockBean
	private WaterRepository waterRepository;
	
	@Autowired
	private WaterServiceImpl waterServiceImpl;
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
	void testSaveWater() {
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		when(waterRepository.save(Mockito.any(Water.class))).thenReturn(water);
		WaterDTO savedWater = waterServiceImpl.saveWater(water);
		assertEquals(water.getId(),savedWater.getId());
	}
	
	@Test
	void testGetById() {
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		when(waterRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(water));
		Water fatchwater = waterServiceImpl.getById(water.getId());
		assertEquals(water.getId(),fatchwater.getId());
	}
	
	@Test
	void testGetByPacketId() {
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		when(waterRepository.findByPacketId(Mockito.anyString())).thenReturn(water);
		WaterDTO fatchByPacketIdWater = waterServiceImpl.findByPacketId(water.getPacketId());
		assertEquals(water.getId(),fatchByPacketIdWater.getId());
	}
	
	@Test
	void testGetAllWater() throws Exception {
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(2);
		water.setStatus(true);
		List<Water> waterList = new ArrayList<Water>();
		waterList.add(water);
		when(waterRepository.findAllOrderByWaterDesc()).thenReturn(waterList);
		List<WaterDTO> fetchWaterList = waterServiceImpl.getAllWater();
		assertEquals(waterList.get(0).getPacketType(),fetchWaterList.get(0).getPacketType());
	}
	
	@Test
	void testUdateWaterDetails() {
		Water water = new Water();
		water.setId(1l);
		water.setPacketId("W1");
		water.setPacketType("Water");
		water.setQuantityInLitres(1);
		water.setStatus(true);
		when(waterRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(water));
		WaterDTO updateWater = waterServiceImpl.updateWaterDetails(water);
		assertEquals(true,updateWater.isStatus());
	}

}
