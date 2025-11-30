package com.example.ram.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.ram.Dto.AdminReviewResponseDto;
import com.example.ram.Dto.ContactQueryRequestDto;
import com.example.ram.Dto.ContactQueryResponseDto;
import com.example.ram.Dto.PublicReviewResponseDto;
import com.example.ram.Dto.ReviewRequestDto;
import com.example.ram.Entity.ContactQuery;
import com.example.ram.Entity.Review;
import com.example.ram.Repository.ContactQueryRepository;
import com.example.ram.Repository.ReviewRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository repo;
    
    @Autowired
    private ContactQueryRepository conRepo;

    // ==========================
    // Public reviews
    // ==========================
    @Transactional(readOnly = true)
    public Page<PublicReviewResponseDto> getPublicReviews(int page, int size) {
        logger.info("Fetching public reviews page={}, size={}", page, size);

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "rating")
                    .and(Sort.by(Sort.Direction.DESC, "createdAt"))
        );

        Page<Review> reviewsPage = repo.findByApprovedTrue(pageable);
        logger.debug("Fetched {} public reviews", reviewsPage.getContent().size());

        return reviewsPage.map(PublicReviewResponseDto::new);
    }

    // ==========================
    // Admin reviews (approved)
    // ==========================
    @Transactional(readOnly = true)
    public Page<AdminReviewResponseDto> getApprovedReviewsForAdmin(int page, int size) {
        logger.info("Fetching approved reviews for admin");

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "rating")
                        .and(Sort.by(Sort.Direction.DESC, "createdAt"))
        );

        Page<Review> reviewsPage = repo.findByApprovedTrue(pageable);
        logger.debug("Admin approved reviews fetched count={}", reviewsPage.getContent().size());

        return reviewsPage.map(AdminReviewResponseDto::new);
    }

    // ==========================
    // Pending admin reviews
    // ==========================
    @Transactional(readOnly = true)
    public Page<AdminReviewResponseDto> getPendingReviewsForAdmin(int page, int size) {
        logger.info("Fetching pending reviews for admin");

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, "rating")
                        .and(Sort.by(Sort.Direction.DESC, "createdAt"))
        );

        Page<Review> reviewsPage = repo.findByApprovedFalse(pageable);
        logger.debug("Admin pending reviews fetched count={}", reviewsPage.getContent().size());

        return reviewsPage.map(AdminReviewResponseDto::new);
    }

    // ==========================
    // Delete a review
    // ==========================
    @Transactional
    public void deleteReview(Long id) {
        logger.info("Attempting to delete review with id={}", id);

        Review review = repo.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Review not found with id={}", id);
                    return new RuntimeException("Review not found with id: " + id);
                });

        repo.delete(review);
        logger.info("Review deleted successfully id={}", id);
    }

    // ==========================
    // Approve a review
    // ==========================
    @Transactional
    public void approveReview(Long id) {
        logger.info("Approving review id={}", id);

        Review review = repo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Review not found during approval id={}", id);
                    return new RuntimeException("Review not found with id: " + id);
                });

        logger.debug("Current approved status={}", review.isApproved());
        review.setApproved(true);
        repo.save(review);

        logger.info("Review approved successfully id={}", id);
    }

    // ==========================
    // Save a new review
    // ==========================
    @Transactional
    public PublicReviewResponseDto saveReview(ReviewRequestDto dto) {
        logger.info("Saving new review");
        logger.debug("Incoming review DTO: name={}, rating={}", dto.getName(), dto.getRating());

        Review review = new Review(dto.getName(), dto.getRating(), dto.getComment());

        Review savedReview = repo.save(review);
        logger.info("Review saved with id={}", savedReview.getId());

        return new PublicReviewResponseDto(savedReview);
    }
    
    @Transactional
    public ContactQueryResponseDto saveContactQuery(ContactQueryRequestDto dto) {
    	
    	  logger.info("Saving new contact query");
    	  logger.debug("Incoming contact DTO: name={}, email={}, mobile={}", dto.getName(), dto.getEmail(), dto.getMobile());
    	  ContactQuery query = new ContactQuery(dto.getName(), dto.getEmail(), dto.getMobile(), dto.getMessage());
    	  ContactQuery saved = conRepo.save(query);
    	  
    	  logger.info("Contact query saved with id={}", saved.getId());
    	  return new ContactQueryResponseDto(saved);
    	  
    	
    }
    
    @Transactional(readOnly = true)
    public Page<ContactQueryResponseDto> getAllQueries(int page,int size){
    	logger.info("Fetching all contact queries for admin");
    	 Pageable pageable = PageRequest.of(
    	            page,
    	            size,
    	            Sort.by(Sort.Direction.DESC, "createdAt")  // newest first
    	    );
    	 Page<ContactQuery> queryPage  = conRepo.findAll(pageable);
    	 logger.debug("Contact queries fetched count={}", queryPage.getContent().size());
    	 
    	 return queryPage.map(ContactQueryResponseDto::new);
    	
    	
    }
}
