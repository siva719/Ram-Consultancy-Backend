package com.example.ram.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactQueryRequestDto {
	
	 @NotBlank(message = "Name is required")
	 @Size(min = 3, max = 100, message = "Name must be between 3–100 characters")
	 private String name;

	 @NotBlank(message = "Email is required")
	 private String email;
	 
	 @NotBlank(message = "Mobile number is required")
	 private String mobile;
	 
	 @NotBlank(message = "Message cannot be empty")
	 @Size(min = 10, max = 2000, message = "Message must be at least 10 characters")
	 private String message;
	 
	 
	public ContactQueryRequestDto(
			String name,
		    String  email,
			String mobile,
			String message) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.message = message;
	}

	public ContactQueryRequestDto() {
		super();
		// TODO Auto-generated constructor stub
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
	 
	 
	 
	 

}
