package com.school.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.school.dto.StudentInfoDTO;
import com.school.dto.UserRegistrationDTO;
import com.school.entity.Role;
import com.school.entity.UserInfo;
import com.school.service.StudentService;

@Controller
public class StudentInfoController {

	@Autowired
	private StudentService studentSercice;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}

	@GetMapping("/registration")
	public String showRegistrationForm() {
		return "registration";
	}

	@PostMapping("/registration")
	public String addNewUser(@ModelAttribute("user") UserRegistrationDTO registrationDTO) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(registrationDTO.getUserName());
		userInfo.setPassword(passwordEncoder.encode(registrationDTO.getPassword()));
		userInfo.setEmail(registrationDTO.getEmail());
		userInfo.setRoles(Arrays.asList(new Role("ROLE_USER")));
		studentSercice.addNewUser(userInfo);
		return "redirect:/registration?success";
	}

	@GetMapping("/studentList")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public List<StudentInfoDTO> loadStudentDetails() {
		return studentSercice.loadStudentDetails();
	}

	@GetMapping("/admin")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String user() {
		return "user";
	}
}