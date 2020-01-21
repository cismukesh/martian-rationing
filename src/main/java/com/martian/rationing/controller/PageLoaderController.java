package com.martian.rationing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.martian.rationing.constants.Constant;
import com.martian.rationing.mapper.RationMapper;
import com.martian.rationing.mapper.WaterMapper;
import com.martian.rationing.model.Ration;
import com.martian.rationing.model.Water;
import com.martian.rationing.service.RationService;
import com.martian.rationing.service.WaterService;

@Controller
@RequestMapping("/load")
public class PageLoaderController {

	@Autowired
	RationService rationService;

	@Autowired
	WaterService waterService;

	@Autowired
	RationMapper rationMapper;

	@Autowired
	WaterMapper waterMapper;

	/**
	 * load martian rationing system home
	 * 
	 * @return String
	 */
	@GetMapping(path = "/rationing-system")
	public String getLocationPage() {
		return Constant.HOME;
	}

	/**
	 * request for add-ration page
	 * 
	 * @return String
	 */
	@GetMapping(path = "/addration")
	public String addRation() {
		return Constant.ADDRATION;
	}

	/**
	 * request for add-water page
	 * 
	 * @return String
	 */
	@GetMapping(path = "/addwater")
	public String addWater() {
		return Constant.ADDWATER;
	}

	/**
	 * request for update ration page
	 *
	 * @param rationId
	 * @return ModelAndView
	 */
	@GetMapping("/updateration")
	public ModelAndView updateRation(@RequestParam("rationid") Long rationId) {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");
		Ration ration = rationService.findById(rationId);
		if (ration != null) {
			model.addObject("ration", rationMapper.mapEntitytoDTO(ration));
			model.setViewName(Constant.UPDATERATION);
			return model;
		} else {
			model.addObject("status", "false");
			model.addObject("message", "Ration Data Not Found!, Please Try Again.");
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
	}

	/**
	 * request for update water page
	 * 
	 * @param waterId
	 * @return ModelAndView
	 */
	@GetMapping("/updatewater")
	public ModelAndView updateWater(@RequestParam("waterid") Long waterId) {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");
		Water water = waterService.getById(waterId);
		if (water != null) {
			model.addObject("water", waterMapper.mapEntitytoDTO(water));
			model.setViewName(Constant.UPDATEWATER);
			return model;
		} else {
			model.addObject("status", "false");
			model.addObject("message", "Water Data Not Found!, Please Try Again.");
			model.setViewName(Constant.VIEWRATION);
			return model;
		}
	}
}
