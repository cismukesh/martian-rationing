package com.martian.rationing.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.mapper.RationMapper;
import com.martian.rationing.model.Ration;
import com.martian.rationing.repository.RationRepository;
import com.martian.rationing.service.RationService;

@Service
public class RationServiceImpl implements RationService {

	@Autowired
	private RationRepository rationRepository;
	
	@Autowired
	private RationMapper rationMapper;

	/**
	 * method implementation for save ration with ration object
	 */
	@Override
	public RationDTO saveRation(Ration ration) {
		Ration oldRation = rationRepository.findByPacketId(ration.getPacketId());
		if (oldRation == null) {
			return rationMapper.mapEntitytoDTO(rationRepository.save(ration));
		} else {
			return null;
		}
	}

	/**
	 * method implementation returns ration list
	 */
	@Override
	public List<RationDTO> getAllRation() {
		return rationMapper.mapEntitystoDTOs(rationRepository.findAllOrderByDateAsc());
	}

	/**
	 * method implementation for get ration by Id
	 */
	@Override
	public Ration findById(Long id) {
		Optional<Ration> ration = rationRepository.findById(id);
		return ration.isPresent() ? ration.get() : null;
	}

	/**
	 * method implementation for delete particular ration
	 */
	@Override
	public void deleteRation(Long id) {
		rationRepository.deleteById(id);
	}

	/**
	 * method implementation for get ration by packetId
	 */
	@Override
	public RationDTO findByPacketId(String packetId) {
		return rationMapper.mapEntitytoDTO(rationRepository.findByPacketId(packetId));
	}

	/**
	 * method implementation for update ration details for particular ration object
	 */
	@Override
	public RationDTO updateRationDetails(Ration ration) {
		Ration oldRation = findById(ration.getId());
		if (oldRation != null) {
			oldRation.setPacketType(ration.getPacketType());
			oldRation.setPacketContent(ration.getPacketContent());
			oldRation.setCalories(ration.getCalories());
			oldRation.setExpiryDate(ration.getExpiryDate());
		    RationDTO rationDto = rationMapper.mapEntitytoDTO(rationRepository.save(oldRation));
			if(rationDto != null) {
				return rationDto;
			}
		}
		return null;
	}

	/**
	 * method implementation for Update status for particular ration object
	 */
	@Override
	public RationDTO updateStatus(Ration ration) {
		Ration oldRation = findById(ration.getId());
		if (oldRation != null) {
			oldRation.setStatus(false);
			return rationMapper.mapEntitytoDTO(rationRepository.save(oldRation));
		} else {
			return null;
		}
	}

	/**
	 * method implementation for Re-update status for all ration object
	 */
	@Override
	public RationDTO reUpdateStatus(Ration ration) {
		Ration oldRation = findById(ration.getId());
		if (oldRation != null) {
			oldRation.setStatus(true);
			return rationMapper.mapEntitytoDTO(rationRepository.save(oldRation));
		} else {
			return null;
		}
	}
}
