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

import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.model.Ration;
import com.martian.rationing.repository.RationRepository;
import com.martian.rationing.service.impl.RationServiceImpl;


/**
 * @author cis
 *
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class RationSeviceImplTest {
	
	@MockBean
	private RationRepository rationRepository;
	
	@Autowired
	private RationServiceImpl rationServiceImpl;

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
	void testSaveRation() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Apple Pie");
		ration.setCalories(1000);
		ration.setExpiryDate("28-01-2020");
		ration.setStatus(true);
		
		when(rationRepository.save(Mockito.any(Ration.class))).thenReturn(ration);
		RationDTO rationSaved = rationServiceImpl.saveRation(ration);
		assertEquals(ration.getId(), rationSaved.getId());	
	}
	
	@Test
	void testGetAllRation() {
		List<Ration> rationList = new ArrayList<Ration>();
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
		
		rationList.add(rationOne);
		rationList.add(rationTwo);
		
		when(rationRepository.findAllOrderByDateAsc()).thenReturn(rationList);
		List<RationDTO> fetchRationList = rationServiceImpl.getAllRation();
		assertEquals(rationList.get(0).getPacketType(), fetchRationList.get(0).getPacketType());
	}
	
	@Test
	void testFindById() {
		Ration rationOne = new Ration();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("28-01-2020");
		rationOne.setStatus(true);
		when(rationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(rationOne));
		Ration fatchedRation = rationServiceImpl.findById(rationOne.getId());
		assertEquals(rationOne.getId(),fatchedRation.getId());
	}
	
	@Test
	void testFindByPacketId() {
		Ration rationOne = new Ration();
		rationOne.setId(2l);
		rationOne.setPacketId("F2");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Protien Bar");
		rationOne.setCalories(1500);
		rationOne.setExpiryDate("30-01-2020");
		rationOne.setStatus(true);
		when(rationRepository.findByPacketId(Mockito.anyString())).thenReturn(rationOne);
		RationDTO fatchedRation = rationServiceImpl.findByPacketId(rationOne.getPacketId());
		assertEquals(rationOne.getPacketId(),fatchedRation.getPacketId());
	}
	
	@Test
	void testUpdateRation() {
		Ration ration = new Ration();
		ration.setId(1l);
		ration.setPacketId("F1");
		ration.setPacketType("Food");
		ration.setPacketContent("Dry-Food");
		ration.setCalories(1500);
		ration.setExpiryDate("30-01-2020");
		ration.setStatus(true);
		when(rationRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ration));
		RationDTO updatedRation = rationServiceImpl.updateRationDetails(ration);
		assertEquals(true,updatedRation.isStatus());
	}

}
