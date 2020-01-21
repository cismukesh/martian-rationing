package com.martian.rationing.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "water")
public class Water implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6670818265989905418L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String packetId;
	@Column
	private String packetType;
	@Column
	private Integer quantityInLitres;
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
}
