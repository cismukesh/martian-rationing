/**
 * 
 */
package com.martian.rationing.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.martian.rationing.dto.RationDTO;
import com.martian.rationing.model.Ration;
import com.martian.rationing.vo.RationVO;

/**
 * @author cis
 *
 */
@Component
public class RationMapper extends AbstractMapper<RationDTO, RationVO, Ration> {

	public RationDTO mapVOtoDTO(RationVO vo) {
		RationDTO dto = new RationDTO();
		super.mapVOtoDTO(vo, dto);
		return dto;
	}

	public RationDTO mapEntitytoDTO(Ration entity) {
		RationDTO dto = new RationDTO();
		super.mapEntitytoDTO(entity, dto);
		return dto;
	}

	public Ration mapDTOtoEntity(RationDTO dto) {
		Ration entity = new Ration();
		super.mapDTOtoEntity(dto, entity);
		return entity;
	}

	public List<Ration> mapDTOstoEntitys(List<RationDTO> dtos) {
		List<Ration> entitys = new ArrayList<Ration>();
		if (dtos != null && !dtos.isEmpty())
			entitys.addAll(dtos.stream().map(dto -> mapDTOtoEntity(dto)).collect(Collectors.toList()));
		return entitys;
	}

	public List<RationDTO> mapEntitystoDTOs(List<Ration> entites) {
		List<RationDTO> dtos = new ArrayList<RationDTO>();
		if (entites != null && !entites.isEmpty())
			dtos.addAll(entites.stream().map(entity -> mapEntitytoDTO(entity)).collect(Collectors.toList()));
		return dtos;
	}
}
