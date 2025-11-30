package com.example.ram.DAO;

import com.example.ram.Dto.AdminReviewResponseDto;
import com.example.ram.Dto.ContactQueryRequestDto;
import com.example.ram.Dto.ContactQueryResponseDto;
import com.example.ram.Dto.PublicReviewResponseDto;
import com.example.ram.Dto.ReviewRequestDto;
import org.springframework.data.domain.Page;

public interface ReviewDao {

    Page<PublicReviewResponseDto> getPublicReviews(int page, int size);

    Page<AdminReviewResponseDto> getApprovedReviews(int page, int size);

    Page<AdminReviewResponseDto> getPendingReviews(int page, int size);

    void deleteReview(Long id);

    void approveReview(Long id);

    PublicReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto);
    
    ContactQueryResponseDto saveContactQuery(ContactQueryRequestDto dto);
    
    Page<ContactQueryResponseDto> getAllQueries(int page,int size);
}