package com.martian.rationing.mapper;

import org.springframework.beans.BeanUtils;

public abstract class AbstractMapper<DTO, VO, ENTITY> {

	/**
	 * Map any type of class VO object to DTO
	 * 
	 * @param vo
	 * @param dto
	 */
	public void mapVOtoDTO(VO vo, DTO dto) {
		copyObject(vo, dto);
	}

	/**
	 * 
	 * @param dto
	 * @param entity
	 */
	public void mapDTOtoEntity(DTO dto, ENTITY entity) {
		copyObject(dto, entity);
	}

	/**
	 * 
	 * @param entity
	 * @param dto
	 */
	public void mapEntitytoDTO(ENTITY entity, DTO dto) {
		copyObject(entity, dto);
	}

	private <S, D> void copyObject(S source, D destination) {
		if (source != null)
			BeanUtils.copyProperties(source, destination);
	}
}
