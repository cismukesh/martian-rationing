package com.martian.rationing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rationing")
public class Ration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2041635502674990850L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String packetId;
	@Column
	private String packetType;
	@Column
	private String packetContent;
	@Column
	private Integer calories;
	@Column
	private String expiryDate;
	@Column
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
	
}
