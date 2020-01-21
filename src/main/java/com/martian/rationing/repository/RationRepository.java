package com.martian.rationing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.martian.rationing.model.Ration;

@Repository
public interface RationRepository extends JpaRepository<Ration, Long> {

	/**
	 * this method returns ration object by packetId
	 * 
	 * @param packetId
	 * @return ration object
	 */
	Ration findByPacketId(String packetId);
	
	/**
	 * query for find all order by ascending on date
	 * @return ration list
	 */
	@Query("Select r from Ration as r order by r.expiryDate")
	List<Ration> findAllOrderByDateAsc();
	
}
