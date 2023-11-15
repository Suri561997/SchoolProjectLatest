package com.school.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.entity.HolidayMaster;
import com.school.repository.HolidayMasterRepository;
import com.school.service.HolidayMasterService;

@Service
public class HolidayMasterServiceImpl implements HolidayMasterService {

	@Autowired
	private HolidayMasterRepository holidayMasterRepository;
	
	@Override
	public List<HolidayMaster> findAll() {
		return holidayMasterRepository.findAll();
	}

}
