package com.school.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.school.common.AuditableColumns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "holiday_master")
@Where(clause = "is_active = true")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class HolidayMaster extends AuditableColumns {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" , nullable = false)
	private Long id;
	
	@Column(name = "holiday_date" , nullable = false , unique = true)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate holidayDate;	

}