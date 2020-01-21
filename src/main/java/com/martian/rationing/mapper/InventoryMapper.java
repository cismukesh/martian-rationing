/**
 * 
 */
package com.martian.rationing.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.martian.rationing.dto.InventoryDTO;
import com.martian.rationing.model.Inventory;
import com.martian.rationing.vo.InventoryVO;

/**
 * @author cis
 *
 */
@Component
public class InventoryMapper extends AbstractMapper<InventoryDTO, InventoryVO, Inventory> {

	public InventoryDTO mapVOtoDTO(InventoryVO vo) {
		InventoryDTO dto = new InventoryDTO();
		super.mapVOtoDTO(vo, dto);
		return dto;
	}

	public InventoryDTO mapEntitytoDTO(Inventory entity) {
		InventoryDTO dto = new InventoryDTO();
		super.mapEntitytoDTO(entity, dto);
		return dto;
	}

	public Inventory mapDTOtoEntity(InventoryDTO dto) {
		Inventory entity = new Inventory();
		super.mapDTOtoEntity(dto, entity);
		return entity;
	}

	public List<Inventory> mapDTOstoEntitys(List<InventoryDTO> dtos) {
		List<Inventory> entitys = new ArrayList<Inventory>();
		if (dtos != null && !dtos.isEmpty())
			entitys.addAll(dtos.stream().map(dto -> mapDTOtoEntity(dto)).collect(Collectors.toList()));
		return entitys;
	}

	public List<InventoryDTO> mapEntitystoDTOs(List<Inventory> entites) {
		List<InventoryDTO> dtos = new ArrayList<InventoryDTO>();
		if (entites != null && !entites.isEmpty())
			dtos.addAll(entites.stream().map(entity -> mapEntitytoDTO(entity)).collect(Collectors.toList()));
		return dtos;
	}
}
