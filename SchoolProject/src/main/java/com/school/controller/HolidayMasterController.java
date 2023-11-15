package com.school.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.school.entity.HolidayMaster;
import com.school.service.HolidayMasterService;

@Controller
public class HolidayMasterController {

	@Autowired
	private HolidayMasterService holidayMasterService;
	
	@GetMapping("/holidayMaster")
	public String getHolidayData(Model model) {
		/*
		 * List<HolidayMaster> holidayData = new ArrayList<>(); holidayData.add(new
		 * HolidayMaster(1L,LocalDate.now())); holidayData.add(new
		 * HolidayMaster(2L,LocalDate.now())); holidayData.add(new
		 * HolidayMaster(3L,LocalDate.now())); holidayData.add(new
		 * HolidayMaster(4L,LocalDate.now())); holidayData.add(new
		 * HolidayMaster(5L,LocalDate.now())); holidayData.add(new
		 * HolidayMaster(6L,LocalDate.now()));
		 */
		model.addAttribute("holidayData", holidayMasterService.findAll());
		return "holidayMaster";
	}
	
}
