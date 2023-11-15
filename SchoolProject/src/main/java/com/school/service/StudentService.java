package com.school.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dto.StudentInfoDTO;
import com.school.entity.UserInfo;
import com.school.repository.UserInfoRepository;

@Service
public class StudentService {
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	public List<StudentInfoDTO> loadStudentDetails(){
		return IntStream.rangeClosed(1, 50)
			.mapToObj(i -> new StudentInfoDTO(i, "Student Name is @@ "+i)).collect(Collectors.toList());
	}
	
	public UserInfo addNewUser(UserInfo userInfo) {
		return userInfoRepository.save(userInfo);
	}
	
}
