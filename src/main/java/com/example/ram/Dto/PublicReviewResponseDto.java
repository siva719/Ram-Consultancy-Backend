package com.example.ram.Dto;

import java.time.LocalDateTime;

import com.example.ram.Entity.Review;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PublicReviewResponseDto {
	
	private String name;
    private int rating;
    private String comment;
    
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime createdAt;
    
    public PublicReviewResponseDto() {
    	
    }
    
    public PublicReviewResponseDto(Review review) {
    	 this.name =  review.getName();
         this.rating =  review.getRating();
         this.comment = review.getComment();
         this.createdAt = review.getCreatedAt();
    }
    
    
    
    public PublicReviewResponseDto(String name, int rating, String comment, LocalDateTime createdAt) {
        this.name = name;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = createdAt;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
}
