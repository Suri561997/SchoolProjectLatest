package com.school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SectionMaster {

	@GetMapping("/sectionMaster")
	public String displaySectionMasterPage() {
		return "masters/sectionMaster";
	}
	
}
