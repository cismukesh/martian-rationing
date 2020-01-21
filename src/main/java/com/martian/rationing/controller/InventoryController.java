package com.martian.rationing.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.martian.rationing.constants.Constant;
import com.martian.rationing.mapper.RationMapper;
import com.martian.rationing.mapper.WaterMapper;
import com.martian.rationing.model.Inventory;
import com.martian.rationing.model.Ration;
import com.martian.rationing.model.Water;
import com.martian.rationing.service.InventoryService;
import com.martian.rationing.service.RationService;
import com.martian.rationing.service.WaterService;

/**
 * @author cis
 *
 */
@Controller
public class InventoryController {

	@Autowired
	private RationService rationService;

	@Autowired
	private WaterService waterService;

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private RationMapper rationMapper;

	@Autowired
	private WaterMapper waterMapper;

	public static LocalDate date = LocalDate.now();
	public static int quantityInLitre;
	public static int totalQuantityInLitre;

	/**
	 * request for view all schedule ration of inventory
	 * 
	 * @return ModelAndView
	 */
	@GetMapping("/viewscheduleration")
	public ModelAndView viewInventoryRation() {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");
		List<Inventory> inventoryList = inventoryService.getAllInventoryData();
		if (!inventoryList.isEmpty()) {
			model.addObject("listsize", inventoryList.size());
			model.addObject("inventoryList", inventoryList);
			model.addObject("message", "Scheduled Inventory is Fetched Successfully!");
			model.setViewName(Constant.INVENTORY_RATION);
			return model;

		} else {
			model.addObject("status", "false");
			model.addObject("message", "Inventory is not Scheduled!, Please Schedule Inventory.");
			model.setViewName(Constant.INVENTORY_RATION);
			return model;
		}
	}

	/**
	 * this method create Schedule based on available ration in inventory
	 * 
	 * @return ModelAndView
	 * @throws ParseException
	 */
	@GetMapping("/scheduleinventory")
	public ModelAndView createSchedule() throws ParseException {

		ModelAndView model = new ModelAndView();

		List<Ration> rationList = rationMapper.mapDTOstoEntitys(rationService.getAllRation());
		List<Water> waterList = waterMapper.mapDTOstoEntitys(waterService.getAllWater());
		List<Ration> ration = new ArrayList<Ration>();
		List<Water> water = new ArrayList<Water>();
		List<Ration> rationKey = new ArrayList<Ration>();
		List<Water> waterStatusList = new ArrayList<Water>();

		// create pair of ration for total 2500 calories
		for (int i = 0; i < rationList.size(); i++) {
			for (int j = i + 1; j < rationList.size(); j++) {
				Integer calorie1 = rationList.get(i).getCalories();
				Integer calorie2 = rationList.get(j).getCalories();
				Integer calorie = calorie1 + calorie2;
				if (calorie.equals(2500)) {
					if (rationList.get(i).isStatus() == true && rationList.get(j).isStatus() == true) {
						ration.add(rationList.get(i));
						ration.add(rationList.get(j));
						Ration r1 = rationList.get(i);
						Ration r2 = rationList.get(j);
						rationList.get(i).setStatus(false);
						rationList.get(j).setStatus(false);
						rationService.updateStatus(r1);
						rationService.updateStatus(r2);
					}
				}
			}
		}

		// for schedule water
		for (int k = 0; k < waterList.size(); k++) {

			if (waterList.get(k).getQuantityInLitres().equals(2) && waterList.get(k).isStatus() == true
					&& ration.size() > 0) {
				water.add(waterList.get(k));
				for (int i = 0; i < 2; i++) {
					rationKey.add(ration.get(i));
				}

				LocalDate expiryDate1 = LocalDate.parse(ration.get(0).getExpiryDate());
				LocalDate expiryDate2 = LocalDate.parse(ration.get(1).getExpiryDate());

				if (expiryDate1.compareTo(date) >= 0 && expiryDate2.compareTo(date) >= 0) {

					Inventory inventory = new Inventory();
					inventory.setDate(date.toString());
					inventory.setRationList(rationKey);
					inventory.setWaterList(water);

					Water w1 = waterList.get(k);
					waterService.updateStatus(w1);

					inventoryService.saveInventory(inventory);
					date = date.plusDays(1);
					rationKey = new ArrayList<Ration>();
					water = new ArrayList<Water>();
					ration.remove(0);
					ration.remove(0);
				} else {
					if (expiryDate1.compareTo(date) < 0 || expiryDate2.compareTo(date) < 0) {
						rationKey = new ArrayList<Ration>();
						water = new ArrayList<Water>();
						if (expiryDate1.compareTo(date) < 0)
							rationService.reUpdateStatus(ration.get(1));
						else
							rationService.reUpdateStatus(ration.get(0));
						ration.remove(0);
						ration.remove(0);
					}
				}

			} else {
				quantityInLitre = waterList.get(k).getQuantityInLitres();
				if (quantityInLitre == 1 && waterList.get(k).isStatus() == true && ration.size() > 0) {
					totalQuantityInLitre = totalQuantityInLitre + quantityInLitre;
					water.add(waterList.get(k));
					Water w = waterList.get(k);
					waterStatusList.add(w);

					if (totalQuantityInLitre == 2) {

						for (int i = 0; i < 2; i++) {
							rationKey.add(ration.get(i));
						}

						LocalDate expiryDate1 = LocalDate.parse(ration.get(0).getExpiryDate());
						LocalDate expiryDate2 = LocalDate.parse(ration.get(1).getExpiryDate());

						if (expiryDate1.compareTo(date) >= 0 && expiryDate2.compareTo(date) >= 0) {
							Inventory inventory = new Inventory();
							inventory.setDate(date.toString());
							inventory.setRationList(rationKey);
							inventory.setWaterList(water);

							inventoryService.saveInventory(inventory);

							date = date.plusDays(1);
							rationKey = new ArrayList<Ration>();
							water = new ArrayList<Water>();
							ration.remove(0);
							ration.remove(0);

							waterService.updateStatus(waterStatusList.get(0));
							waterService.updateStatus(waterStatusList.get(1));
							waterStatusList = new ArrayList<Water>();
							totalQuantityInLitre = 0;
						} else {
							if (expiryDate1.compareTo(date) < 0 || expiryDate2.compareTo(date) < 0) {
								rationKey = new ArrayList<Ration>();
								water = new ArrayList<Water>();
								if (expiryDate1.compareTo(date) < 0)
									rationService.reUpdateStatus(ration.get(1));
								else
									rationService.reUpdateStatus(ration.get(0));
								ration.remove(0);
								ration.remove(0);
								waterStatusList = new ArrayList<Water>();
								totalQuantityInLitre = 0;
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < ration.size(); i++) {
			Ration rationStatusUpd = ration.get(i);
			rationService.reUpdateStatus(rationStatusUpd);
		}
		ration = new ArrayList<Ration>();

		List<Inventory> inventoryList = inventoryService.getAllInventoryData();

		if (!inventoryList.isEmpty()) {
			model.addObject("listsize", inventoryList.size());
			model.addObject("inventoryList", inventoryList);
			model.addObject("status", "true");
			model.addObject("message", "Ration Scheduled Successfully!");
			model.setViewName(Constant.INVENTORY_RATION);
		} else {
			model.addObject("status", "false");
			model.addObject("message", "Ration Scheduled Failed!, Please Add Enough Ration in Inventory.");
			model.setViewName(Constant.INVENTORY_RATION);
		}

		return model;
	}
	
	
	/**
	 * this method delete Scheduled ration from inventory and update the status of ration
	 * 
	 * @return ModelAndView
	 * @throws ParseException
	 */
	@GetMapping("/resetschedule")
	public ModelAndView resetSchedule(HttpSession session) throws ParseException {
		ModelAndView model = new ModelAndView();
		model.addObject("status", "true");
		model.setViewName(Constant.VIEW_UPDATE_REDIRECT);
		List<Inventory> inventoryList = inventoryService.getAllInventoryData();
		
		if(!inventoryList.isEmpty()) {
		inventoryList.forEach(inventory->{
			
			List<Water> waterObj = inventory.getWaterList();
			List<Ration> rationObj  = inventory.getRationList();
			
			waterObj.forEach(action->{
				waterService.reUpdateStatus(action);
			});
			
			rationObj.forEach(action->{
				rationService.reUpdateStatus(action);
			});
		});
		
		inventoryService.deleteAllInventoryData();
		date = LocalDate.now();
		quantityInLitre = 0;
		totalQuantityInLitre = 0;
		session.setAttribute("message", "Ration Schedule Reset successful !");
		}
		else {
			session.setAttribute("message", "Schedule ration list is empty, Please First Schedule Ration!");
			return model;
		}
		
		return model;
	}
	
}
