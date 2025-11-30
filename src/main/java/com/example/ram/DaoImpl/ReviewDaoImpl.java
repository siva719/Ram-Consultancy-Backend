package com.example.ram.DaoImpl;

import com.example.ram.DAO.ReviewDao;
import com.example.ram.Dto.AdminReviewResponseDto;
import com.example.ram.Dto.ContactQueryRequestDto;
import com.example.ram.Dto.ContactQueryResponseDto;
import com.example.ram.Dto.PublicReviewResponseDto;
import com.example.ram.Dto.ReviewRequestDto;
import com.example.ram.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;

@Component
public class ReviewDaoImpl implements ReviewDao {
	 @Autowired
	 private ReviewService reviewService;

	@Override
	public Page<PublicReviewResponseDto> getPublicReviews(int page, int size) {
		// TODO Auto-generated method stub
		return reviewService.getPublicReviews(page, size);
	}

	@Override
	public Page<AdminReviewResponseDto> getApprovedReviews(int page, int size) {
		// TODO Auto-generated method stub
		return reviewService.getApprovedReviewsForAdmin(page, size);
	}

	@Override
	public Page<AdminReviewResponseDto> getPendingReviews(int page, int size) {
		// TODO Auto-generated method stub
		return reviewService.getPendingReviewsForAdmin(page, size);
	}

	@Override
	public void deleteReview(Long id) {
		// TODO Auto-generated method stub
		 reviewService.deleteReview(id);
	}

	@Override
	public void approveReview(Long id) {
		// TODO Auto-generated method stub
		reviewService.approveReview(id);
		
	}

	@Override
	public PublicReviewResponseDto saveReview(ReviewRequestDto reviewRequestDto) {
		// TODO Auto-generated method stub
		 return reviewService.saveReview(reviewRequestDto);
	}

	@Override
	public ContactQueryResponseDto saveContactQuery(ContactQueryRequestDto dto) {
		// TODO Auto-generated method stub
		return reviewService.saveContactQuery(dto);
	}

	@Override
	public Page<ContactQueryResponseDto> getAllQueries(int page, int size) {
		// TODO Auto-generated method stub
		return reviewService.getAllQueries(page, size);
	}
	 
	 
}