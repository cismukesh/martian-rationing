package com.martian.rationing.dto;

import java.util.List;

public class InventoryDTO {
	
	private long id;
	private List<RationDTO> rationList;
	private List<WaterDTO> waterList;
	private String date;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the rationList
	 */
	public List<RationDTO> getRationList() {
		return rationList;
	}
	/**
	 * @param rationList the rationList to set
	 */
	public void setRationList(List<RationDTO> rationList) {
		this.rationList = rationList;
	}
	/**
	 * @return the waterList
	 */
	public List<WaterDTO> getWaterList() {
		return waterList;
	}
	/**
	 * @param waterList the waterList to set
	 */
	public void setWaterList(List<WaterDTO> waterList) {
		this.waterList = waterList;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Inventory [id=");
		builder.append(id);
		builder.append(", rationList=");
		builder.append(rationList);
		builder.append(", waterList=");
		builder.append(waterList);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
}
