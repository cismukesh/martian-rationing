package com.martian.rationing.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.martian.rationing.constants.Constant;
import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.enums.StatusEnum;
import com.martian.rationing.exceptions.BadRequestException;
import com.martian.rationing.mapper.RationMapper;
import com.martian.rationing.mapper.WaterMapper;
import com.martian.rationing.model.Ration;
import com.martian.rationing.model.Water;
import com.martian.rationing.service.RationService;
import com.martian.rationing.service.WaterService;
import com.martian.rationing.vo.RationVO;
import com.martian.rationing.vo.WaterVO;


/**
 * @author cis
 *
 */
@Controller
public class RationingController {

	@Autowired
	private RationService rationService;

	@Autowired
	private WaterService waterService;

	@Autowired
	private RationMapper rationMapper;

	@Autowired
	private WaterMapper waterMapper;
	
	// ====================== Ration Api's =======================//
	
	/**
	 * this method add ration in Martian Rationing System
	 * 
	 * @param rationVO
	 * @return ModelAndView
	 * @throws BadRequestException
	 */
	@PostMapping(path = "/saveration")
	public ModelAndView addRation(@ModelAttribute RationVO rationVO) throws BadRequestException {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");

		RationDTO rationDTO = rationMapper.mapVOtoDTO(rationVO);
		if (rationDTO == null) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}

		rationDTO = rationService.saveRation(rationMapper.mapDTOtoEntity(rationDTO));

		if (rationDTO != null) {
			model.addObject("message", "Ration Added successfully!");
			model.setViewName(Constant.ADDRATION);
			return model;
		} else {
			model.addObject("status", "false");
			model.addObject("message", "Ration Not Added! Please Insert Unique Ration Packet Id");
			model.setViewName(Constant.ADDRATION);
			return model;
		}

	}

	/**
	 * request for view all ration (food and water) of inventory
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/viewration")
	public ModelAndView viewRation() {
		ModelAndView model = new ModelAndView();
		model.addObject("status","true");
		List<RationDTO> ration = rationService.getAllRation();
		List<WaterDTO> water = waterService.getAllWater();
		if (!ration.isEmpty() || !water.isEmpty()) {
			model.addObject("rationlists", ration);
			model.addObject("waterlists", water);
			model.addObject("message", "Inventory is Fetched Successfully!");
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
		else {
			model.addObject("status","false");
			model.addObject("message", "Inventory is Empty! Please add Ration.");
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
	}
	
	
	/**
	 * request for view ration of inventory after ration update
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/viewration-update")
	public ModelAndView viewUpdateRation(HttpSession session) {
		ModelAndView model = new ModelAndView();
		model.addObject("status","true");
		List<RationDTO> ration = rationService.getAllRation();
		List<WaterDTO> water = waterService.getAllWater();
		if (!ration.isEmpty() || !water.isEmpty()) {
			model.addObject("rationlists", ration);
			model.addObject("waterlists", water);
			model.addObject("message", session.getAttribute("message"));
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
		else {
			model.addObject("status","false");
			model.addObject("message", session.getAttribute("message"));
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
	}
	
	/**
	 * this method update ration detail in inventory
	 * 
	 * @param rationVO
	 * @param session
	 * @return ModelAndView
	 * @throws ParseException
	 * @throws BadRequestException
	 */
	@PostMapping("/updaterationdetail")
	public ModelAndView updateRationDetails(@ModelAttribute RationVO rationVO,HttpSession session) throws ParseException, BadRequestException {
		RationDTO rationDTO = rationMapper.mapVOtoDTO(rationVO);
		ModelAndView model = new ModelAndView();
		model.addObject("status","true");
		
		if (rationDTO == null) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}
		
		rationDTO = rationService.updateRationDetails(rationMapper.mapDTOtoEntity(rationDTO));
		
		if (rationDTO != null) {
			session.setAttribute("message", "Ration Update successfully!");
			model.setViewName(Constant.VIEW_UPDATE_REDIRECT);
			return model;
		} else {
			session.setAttribute("message", "Ration Details Updation Faild!, try again");
			model.setViewName(Constant.VIEW_UPDATE_REDIRECT);
			return model;
		}
	}
	
	/**
	 * request for delete ration on ration id
	 * 
	 * @param rationId
	 * @param session
	 * @return
	 */
	@GetMapping("/deleteration")
	public ModelAndView deleteRation(@RequestParam("rationid") Long rationId, HttpSession session) {
		Ration ration = rationService.findById(rationId);
		if (ration != null) {
			rationService.deleteRation(rationId);
			session.setAttribute("message", "Ration Deleted Successfully!");
		} else {
			session.setAttribute("message", "Ration Deletion Failed!, Please try again.");
		}
		
		return new ModelAndView(Constant.VIEW_UPDATE_REDIRECT);
	}
	
	
	// ====================== water Api's =======================//

	/**
	 * this method add water in Martian Rationing System
	 * 
	 * @param waterVO
	 * @return ModelAndView
	 * @throws BadRequestException
	 */
	@PostMapping("/savewater")
	public ModelAndView saveWater(@ModelAttribute WaterVO waterVO) throws BadRequestException {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");

		WaterDTO waterDto = waterMapper.mapVOtoDTO(waterVO);
		if (waterDto == null) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}

		waterDto = waterService.saveWater(waterMapper.mapDTOtoEntity(waterDto));

		if (waterDto != null) {
			String success = "Water Added Successfully";
			model.addObject("message", success);
			model.setViewName(Constant.ADDWATER);
			return model;
		} else {
			model.addObject("status", "false");
			model.addObject("message", "Water Not Added ! Please Insert Unique Water Packet Id");
			model.setViewName(Constant.ADDWATER);
			return model;
		}
	}
	
	/**
	 * this method update water detail in inventory
	 * 
	 * @param waterVO
	 * @param session
	 * @return ModelAndView
	 * @throws BadRequestException
	 */
	@PostMapping("/updatewaterdetail")
	public ModelAndView updateWaterDetails(@ModelAttribute WaterVO waterVO,HttpSession session) throws BadRequestException {
		WaterDTO waterDto = waterMapper.mapVOtoDTO(waterVO);
		ModelAndView model = new ModelAndView();
		model.addObject("status","true");
		
		if (waterDto == null) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}
		
		waterDto = waterService.updateWaterDetails(waterMapper.mapDTOtoEntity(waterDto));
		if (waterDto != null) {
			session.setAttribute("message", "Water Update successfully!");
			model.setViewName(Constant.VIEW_UPDATE_REDIRECT);
			return model;
		} else {
			session.setAttribute("message", "Water Details Updation Faild!, Please try again");
			model.setViewName(Constant.VIEW_UPDATE_REDIRECT);
			return model;
		}
	}
	
	/**
	 * request for delete water on water id
	 * 
	 * @param waterId
	 * @param session
	 * @return redirect on view-ration
	 */
	@GetMapping("/deletewater")
	public ModelAndView deleteWater(@RequestParam("waterid") Long waterId, HttpSession session) {
		Water water = waterService.getById(waterId);
		if (water != null) {
			waterService.deleteWater(waterId);
			session.setAttribute("message", "Water Deleted Successfully!");
		} else {
			session.setAttribute("message", "Water Deletion Failed!, Please try again.");
		}
		return new ModelAndView(Constant.VIEW_UPDATE_REDIRECT);
	}
}
