package com.martian.rationing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.martian.rationing.model.Water;

@Repository
public interface WaterRepository extends JpaRepository<Water,Long> {

	/**
	 * this method return water object by packetId
	 * @param packetId
	 * @return water object
	 */
	Water findByPacketId(String packetId);
	
	/**
	 * query for getting water in descending order
	 * @return water list
	 */
	@Query("Select w from Water as w order by w.quantityInLitres desc")
	List<Water> findAllOrderByWaterDesc();
}
