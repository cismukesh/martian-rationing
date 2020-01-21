/**
 * 
 */
package com.martian.rationing.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.martian.rationing.dto.WaterDTO;
import com.martian.rationing.model.Water;
import com.martian.rationing.vo.WaterVO;

/**
 * @author cis
 *
 */
@Component
public class WaterMapper extends AbstractMapper<WaterDTO, WaterVO, Water> {

	public WaterDTO mapVOtoDTO(WaterVO vo) {
		WaterDTO dto = new WaterDTO();
		super.mapVOtoDTO(vo, dto);
		return dto;
	}

	public WaterDTO mapEntitytoDTO(Water entity) {
		WaterDTO dto = new WaterDTO();
		super.mapEntitytoDTO(entity, dto);
		return dto;
	}

	public Water mapDTOtoEntity(WaterDTO dto) {
		Water entity = new Water();
		super.mapDTOtoEntity(dto, entity);
		return entity;
	}

	public List<Water> mapDTOstoEntitys(List<WaterDTO> dtos) {
		List<Water> entitys = new ArrayList<Water>();
		if (dtos != null && !dtos.isEmpty())
			entitys.addAll(dtos.stream().map(dto -> mapDTOtoEntity(dto)).collect(Collectors.toList()));
		return entitys;
	}

	public List<WaterDTO> mapEntitystoDTOs(List<Water> entites) {
		List<WaterDTO> dtos = new ArrayList<WaterDTO>();
		if (entites != null && !entites.isEmpty())
			dtos.addAll(entites.stream().map(entity -> mapEntitytoDTO(entity)).collect(Collectors.toList()));
		return dtos;
	}
}
