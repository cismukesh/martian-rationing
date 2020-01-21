package com.martian.rationing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.mapper.WaterMapper;
import com.martian.rationing.model.Water;
import com.martian.rationing.repository.WaterRepository;
import com.martian.rationing.service.WaterService;

@Service
public class WaterServiceImpl implements WaterService {

	@Autowired
	private WaterRepository waterRepository;
	
	@Autowired
	private WaterMapper waterMapper;

	/**
	 * method implementation for save water object
	 */
	@Override
	public WaterDTO saveWater(Water water) {
		Water oldWater = waterRepository.findByPacketId(water.getPacketId());
		if (oldWater == null) {
			return waterMapper.mapEntitytoDTO(waterRepository.save(water));
		} else {
			return null;
		}
	}

	/**
	 * method implementation for get list of water
	 */
	@Override
	public List<WaterDTO> getAllWater() {
		return waterMapper.mapEntitystoDTOs(waterRepository.findAllOrderByWaterDesc());
	}

	/**
	 * method implementation for delete water for particular-Id
	 */
	@Override
	public void deleteWater(Long id) {
		waterRepository.deleteById(id);
	}

	/**
	 * method implementation for get water by particular-Id
	 */
	@Override
	public Water getById(Long id) {
		Optional<Water> water = waterRepository.findById(id);
		return water.isPresent() ? water.get() : null;
	}

	/**
	 * method implementation for get water by particular packetId
	 */
	@Override
	public WaterDTO findByPacketId(String packetId) {
		return waterMapper.mapEntitytoDTO(waterRepository.findByPacketId(packetId));
	}

	/**
	 * method implementation for update particular water details
	 */
	@Override
	public WaterDTO updateWaterDetails(Water water) {
		Water oldWater = getById(water.getId());
		if (oldWater != null) {
			oldWater.setPacketType(water.getPacketType());
			oldWater.setQuantityInLitres(water.getQuantityInLitres());
		    WaterDTO waterDto=  waterMapper.mapEntitytoDTO(waterRepository.save(oldWater));
		    if(waterDto != null)
		    return waterDto;
		} 
			return null;
		
	}

	/**
	 * method implementation for update status by water object
	 */
	@Override
	public WaterDTO updateStatus(Water water) {
		Water oldWater = getById(water.getId());
		if (oldWater != null) {
			oldWater.setStatus(false);
			return waterMapper.mapEntitytoDTO(waterRepository.save(oldWater));
		} else {
			return null;
		}

	}
	
	/**
	 * method implementation for re-update status by water object
	 */
	@Override
	public WaterDTO reUpdateStatus(Water water) {
		Water oldWater = getById(water.getId());
		if (oldWater != null) {
			oldWater.setStatus(true);
			return waterMapper.mapEntitytoDTO(waterRepository.save(oldWater));
		} else {
			return null;
		}

	}

}
