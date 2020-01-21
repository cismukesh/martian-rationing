package com.martian.rationing.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1662489677164638178L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany
	private List<Ration> rationList;
	
	@OneToMany
	private List<Water> waterList;
	
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
	public List<Ration> getRationList() {
		return rationList;
	}
	/**
	 * @param rationList the rationList to set
	 */
	public void setRationList(List<Ration> rationList) {
		this.rationList = rationList;
	}
	/**
	 * @return the waterList
	 */
	public List<Water> getWaterList() {
		return waterList;
	}
	/**
	 * @param waterList the waterList to set
	 */
	public void setWaterList(List<Water> waterList) {
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
}
