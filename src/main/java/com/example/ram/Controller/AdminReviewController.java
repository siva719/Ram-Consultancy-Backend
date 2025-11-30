package com.example.ram.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.ram.DAO.ReviewDao;
import com.example.ram.Dto.AdminReviewResponseDto;
import com.example.ram.Dto.ContactQueryResponseDto;


@RestController
@RequestMapping("/api/admin/reviews")
@CrossOrigin
public class AdminReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminReviewController.class);

    @Autowired
    private ReviewDao reviewDao;

    // ==========================
    // Get Pending Reviews
    // ==========================
    @GetMapping("/pending")
    public Page<AdminReviewResponseDto> getPendingReviews(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("Admin API Called: Fetch pending reviews (page={}, size={})", page, size);

        Page<AdminReviewResponseDto> result = reviewDao.getPendingReviews(page, size);

        logger.debug("Pending reviews fetched: count={}", result.getContent().size());

        return result;
    }

    // ==========================
    // Get Approved Reviews
    // ==========================
    @GetMapping("/approved")
    public Page<AdminReviewResponseDto> getApprovedReviews(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("Admin API Called: Fetch approved reviews (page={}, size={})", page, size);

        Page<AdminReviewResponseDto> result = reviewDao.getApprovedReviews(page, size);

        logger.debug("Approved reviews fetched: count={}", result.getContent().size());

        return result;
    }

    // ==========================
    // Get All Queries
    // ==========================
    @GetMapping("/contact-queries")
    public Page<ContactQueryResponseDto> getAllContactQueries( @RequestParam int page,
            @RequestParam int size){
    	
    	logger.info("Admin API Called: Fetch all contact queries (page={}, size={})", page, size);
    	
    	 Page<ContactQueryResponseDto> result = reviewDao.getAllQueries(page, size);
    	 
    	 logger.debug("Contact queries fetched: count={}", result.getContent().size());
    	 
    	 return result;

    	
    }
    
    // ==========================
    // Approve a Review
    // ==========================
    @PutMapping("/approve/{id}")
    public ResponseEntity<String> approveReview(@PathVariable Long id) {
        logger.info("Admin API Called: Approve review id={}", id);

        reviewDao.approveReview(id);

        logger.info("Review approved successfully id={}", id);

        return ResponseEntity.ok("Review approved!");
    }

    // ==========================
    // Delete a Review
    // ==========================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable Long id) {
        logger.warn("Admin API Called: Delete review id={}", id);

        reviewDao.deleteReview(id);

        logger.info("Review deleted successfully id={}", id);

        return ResponseEntity.ok("Review deleted!");
    }
	

}
