package com.martian.rationing.service;

import java.util.List;

import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.model.Ration;

public interface RationService {

	RationDTO saveRation(Ration ration);

	List<RationDTO> getAllRation();

	Ration findById(Long id);

	RationDTO findByPacketId(String packetId);

	void deleteRation(Long id);
	
	RationDTO updateRationDetails(Ration ration);
	
	RationDTO updateStatus(Ration ration);
	
	RationDTO reUpdateStatus(Ration ration);
}
