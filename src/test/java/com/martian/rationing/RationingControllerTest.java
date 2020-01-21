/**
 * 
 */
package com.martian.rationing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import org.springframework.web.servlet.ModelAndView;

import com.martian.rationing.controller.RationingController;
import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.exceptions.BadRequestException;
import com.martian.rationing.mapper.RationMapper;
import com.martian.rationing.mapper.WaterMapper;
import com.martian.rationing.model.Ration;
import com.martian.rationing.service.RationService;
import com.martian.rationing.service.WaterService;
import com.martian.rationing.vo.RationVO;

/**
 * @author cis
 *
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
class RationingControllerTest {

	@MockBean
	private WaterService waterService;

	@MockBean
	private RationService rationService;

	@Autowired
	private RationingController rationingController;

	@Autowired
	private WaterMapper waterMapper;

	@Autowired
	private RationMapper rationMapper;

	@Autowired
	private HttpSession httpSession;

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
	void test() {

	}

	@Test
	void testAddRation() throws BadRequestException {
		RationVO rationVO = new RationVO();
		rationVO.setId(1l);
		rationVO.setPacketId("F1");
		rationVO.setPacketType("Food");
		rationVO.setPacketContent("Apple Pie");
		rationVO.setCalories(1000);
		rationVO.setExpiryDate("28-01-2020");
		rationVO.setStatus(true);

		RationDTO rationOne = rationMapper.mapVOtoDTO(rationVO);

		when(rationService.saveRation(Mockito.any(Ration.class))).thenReturn(rationOne);
		ModelAndView response = rationingController.addRation(rationVO);
		assertEquals("addration", response.getViewName());
	}

	@Test
	void testViewRation() throws Exception {
		RationDTO rationOne = new RationDTO();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("28-01-2020");
		rationOne.setStatus(true);

		RationDTO rationTwo = new RationDTO();
		rationTwo.setId(2l);
		rationTwo.setPacketId("F2");
		rationTwo.setPacketType("Food");
		rationTwo.setPacketContent("Protien Bar");
		rationTwo.setCalories(1500);
		rationTwo.setExpiryDate("30-01-2020");
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

		ModelAndView mv = rationingController.viewRation();
		assertEquals("viewration", mv.getViewName());

	}

	@Test
	void testUpdateRationDetails() throws BadRequestException, ParseException {
		RationVO rationVO = new RationVO();
		rationVO.setId(1l);
		rationVO.setPacketId("F1");
		rationVO.setPacketType("Food");
		rationVO.setPacketContent("Apple Pie");
		rationVO.setCalories(1000);
		rationVO.setExpiryDate("28-01-2020");
		rationVO.setStatus(true);

		RationDTO rationDTO = rationMapper.mapVOtoDTO(rationVO);
		when(rationService.updateRationDetails(rationMapper.mapDTOtoEntity(rationDTO))).thenReturn(getRationResponse());
		ModelAndView mv = rationingController.updateRationDetails(rationVO, httpSession);
		assertEquals("redirect:/viewration-update", mv.getViewName());
	}

	@Test
	void testDeleteRation() {
		Ration rationOne = new Ration();
		rationOne.setId(1l);
		rationOne.setPacketId("F1");
		rationOne.setPacketType("Food");
		rationOne.setPacketContent("Apple Pie");
		rationOne.setCalories(1000);
		rationOne.setExpiryDate("28-01-2020");
		rationOne.setStatus(true);

		when(rationService.findById(1l)).thenReturn(rationOne);
		ModelAndView mv = rationingController.deleteRation(1l, httpSession);
		assertEquals("redirect:/viewration-update", mv.getViewName());

	}

	private RationDTO getRationResponse() {
		RationDTO rationTwo = new RationDTO();
		rationTwo.setId(1l);
		rationTwo.setPacketId("F1");
		rationTwo.setPacketType("Food");
		rationTwo.setPacketContent("Protien Bar");
		rationTwo.setCalories(1500);
		rationTwo.setExpiryDate("30-01-2020");
		rationTwo.setStatus(true);
		return rationTwo;
	}

}
