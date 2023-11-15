package com.school.common;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.school.config.UserInfoUserDetails;
import com.school.entity.UserInfo;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@MappedSuperclass
@Data
public class AuditableColumns implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "created_date", insertable = true, updatable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private LocalDate createdDate = LocalDate.now();

	@Column(name = "updated_date", insertable = false, updatable = true)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	@Temporal(TemporalType.DATE)
	private LocalDate updtedDate;

	@Column(name = "created_timestamp", insertable = true, updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdTimeStamp;

	@Column(name = "updated_timestamp", insertable = false, updatable = true)
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedTimeStamp;

	@Column(name = "is_active")
	private Boolean isActive = Boolean.TRUE;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	private UserInfo createdUser;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	private UserInfo lastUpdatedUser;
	
	@PrePersist
	public void settingCreatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			UserInfoUserDetails userDetails = (UserInfoUserDetails) authentication.getPrincipal();
			setCreatedUser(new UserInfo(userDetails.getId()));
		}
	}

	@PreUpdate
	public void settingUpdatedUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			UserInfoUserDetails userDetails = (UserInfoUserDetails) authentication.getPrincipal();
			setLastUpdatedUser(new UserInfo(userDetails.getId()));
		}
	}
}