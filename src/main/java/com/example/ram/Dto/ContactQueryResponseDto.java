package com.example.ram.Dto;

import java.time.LocalDateTime;

import com.example.ram.Entity.ContactQuery;

public class ContactQueryResponseDto {
	    private Long id;
	    private String name;
	    private String email;
	    private String mobile;
	    private String message;
	    private LocalDateTime createdAt;
		public ContactQueryResponseDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public ContactQueryResponseDto(ContactQuery contactQuery) {
			this.id = contactQuery.getId();
			this.name =contactQuery.getName();
			this.email = contactQuery.getEmail();
			this.mobile = contactQuery.getMobile();
			this.message = contactQuery.getMessage();
			this.createdAt = contactQuery.getCreatedAt();
		}
		
		public ContactQueryResponseDto(Long id, String name, String email, String mobile, String message,
				LocalDateTime createdAt) {
			super();
			this.id = id;
			this.name = name;
			this.email = email;
			this.mobile = mobile;
			this.message = message;
			this.createdAt = createdAt;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
	    
	    
}
