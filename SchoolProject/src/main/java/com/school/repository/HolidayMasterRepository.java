package com.school.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.HolidayMaster;

@Repository
public interface HolidayMasterRepository extends JpaRepository<HolidayMaster, Long> {
	
	public List<HolidayMaster> findAll();

}
