package com.martian.rationing.dto;


public class RationDTO {

	private long id;
	private String packetId;
	private String packetType;
	private String packetContent;
	private Integer calories;
	private String expiryDate;
	private boolean status = true; 
	
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
	 * @return the packetId
	 */
	public String getPacketId() {
		return packetId;
	}
	/**
	 * @param packetId the packetId to set
	 */
	public void setPacketId(String packetId) {
		this.packetId = packetId;
	}
	/**
	 * @return the packetType
	 */
	public String getPacketType() {
		return packetType;
	}
	/**
	 * @param packetType the packetType to set
	 */
	public void setPacketType(String packetType) {
		this.packetType = packetType;
	}
	/**
	 * @return the packetContent
	 */
	public String getPacketContent() {
		return packetContent;
	}
	/**
	 * @param packetContent the packetContent to set
	 */
	public void setPacketContent(String packetContent) {
		this.packetContent = packetContent;
	}
	/**
	 * @return the calories
	 */
	public Integer getCalories() {
		return calories;
	}
	/**
	 * @param calories the calories to set
	 */
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ration [id=");
		builder.append(id);
		builder.append(", packetId=");
		builder.append(packetId);
		builder.append(", packetType=");
		builder.append(packetType);
		builder.append(", packetContent=");
		builder.append(packetContent);
		builder.append(", calories=");
		builder.append(calories);
		builder.append(", expiryDate=");
		builder.append(expiryDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
	
}
