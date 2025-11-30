package com.example.ram.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.example.ram.DAO.ReviewDao;
import com.example.ram.Dto.AdminReviewResponseDto;
import com.example.ram.Dto.ContactQueryRequestDto;
import com.example.ram.Dto.ContactQueryResponseDto;
import com.example.ram.Dto.PublicReviewResponseDto;
import com.example.ram.Dto.ReviewRequestDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin
public class ReviewController {

    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    private ReviewDao reviewDao;

    @PostMapping("/add")
    public ResponseEntity<PublicReviewResponseDto> addReview(
            @Valid @RequestBody ReviewRequestDto dto
    ) {
        logger.info("API Called: Add Review");
        logger.debug("Incoming Review DTO -> name={}, rating={}, commentLength={}",
                dto.getName(), dto.getRating(), dto.getComment().length());

        PublicReviewResponseDto response = reviewDao.saveReview(dto);

        logger.info("Review saved successfully");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ==========================
    // Get Approved Reviews (PUBLIC)
    // ==========================
    @GetMapping("/list")
    public Page<PublicReviewResponseDto> getReviews(
            @RequestParam int page,
            @RequestParam int size
    ) {
        logger.info("API Called: Fetch Public Reviews (page={}, size={})", page, size);

        Page<PublicReviewResponseDto> result = reviewDao.getPublicReviews(page, size);

        logger.debug("Reviews fetched: count={}", result.getContent().size());

        return result;
    }
    
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
    
    @PostMapping("/addQuery")
    public ResponseEntity<ContactQueryResponseDto> saveContactQuery(@Valid @RequestBody ContactQueryRequestDto dto){
    	logger.info("API Call Started : Add ContactQuery");
    	
    	ContactQueryResponseDto response = reviewDao.saveContactQuery(dto);
    	
    	logger.info("Contact Query Saved Successfully");
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(response);
    	
    }
}
