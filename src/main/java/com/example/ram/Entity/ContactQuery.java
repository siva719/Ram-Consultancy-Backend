package com.example.ram.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContactQuery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	 @Column(nullable = false)
	private String name;
	 @Column(nullable = false)
	private String email;
	
	 @Column(nullable = false)
	 private String mobile;
	 
	 @CreationTimestamp
	 private LocalDateTime createdAt;

	 
	 @Column(nullable = false, columnDefinition = "TEXT")
	 private String message;

	public ContactQuery() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ContactQuery( String name, String email, String mobile, String message) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.message = message;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
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
