package com.martian.rationing.dto;


public class WaterDTO {

	private long id;
	private String packetId;
	private String packetType;
	private Integer quantityInLitres;
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
	 * @return the quantityInLitres
	 */
	public Integer getQuantityInLitres() {
		return quantityInLitres;
	}

	/**
	 * @param quantityInLitres the quantityInLitres to set
	 */
	public void setQuantityInLitres(Integer quantityInLitres) {
		this.quantityInLitres = quantityInLitres;
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
		builder.append("Water [id=");
		builder.append(id);
		builder.append(", packetId=");
		builder.append(packetId);
		builder.append(", packetType=");
		builder.append(packetType);
		builder.append(", quantityInLitres=");
		builder.append(quantityInLitres);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
	
}
