package com.martian.rationing.service;

import java.util.List;

import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.model.Water;

public interface WaterService {

	WaterDTO saveWater(Water water);

	Water getById(Long id);

	WaterDTO findByPacketId(String packetId);

	List<WaterDTO> getAllWater();

	WaterDTO updateWaterDetails(Water water);
	
	WaterDTO updateStatus(Water water);
	
	WaterDTO reUpdateStatus(Water water);

	void deleteWater(Long id);

}
