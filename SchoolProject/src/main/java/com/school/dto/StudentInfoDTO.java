package com.school.dto;

public class StudentInfoDTO {

	private Integer studentID;
	
	private String studentName;
	
	public StudentInfoDTO(Integer studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "StudentInfoDTO [studentID=" + studentID + ", studentName=" + studentName + "]";
	}
	
}